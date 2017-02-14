package com.sd.uni.labpatologia.article_movement

import com.sd.uni.labpatologia.beans.article_movement.ArticleMovementB
import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.article_movement.ArticleMovementServiceImpl
import com.sd.uni.labpatologia.service.article_movement.IArticleMovementService
import com.sd.uni.labpatologia.service.auth.IAuthService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.util.MovementTypeEnum
import grails.plugin.springsecurity.annotation.Secured;
import java.util.Calendar;
import java.text.SimpleDateFormat
import org.springframework.beans.factory.annotation.Autowired
import com.sd.uni.labpatologia.beans.article_movement.ArticleMovementB;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.sd.uni.labpatologia.utils.PageEvent;
import java.util.HashMap;
import com.sd.uni.labpatologia.util.MovementTypeEnum;

class ArticleMovementController {
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    //services
    def IArticleMovementService articleMovementService
    def ILaboratoryService laboratoryService
    def IArticleService articleService
    @Autowired def IAuthService authService

    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_TECNICO'
	])
    def index() {
        redirect(action: "list", params: params)
    }

    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_TECNICO'
	])
    def create(){
        [articleMovementInstance: new ArticleMovementB(params), articles: articleService.getAll(), laboratoryInstanceList: laboratoryService.getAll(),
            user:authService.getName()]
    }

    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_TECNICO'
	])
    def list(Integer max) {
        def page = 0
        def siguiente
        if(null != params.get("page")){
            page = Integer.parseInt(params.get("page"))
        }
        def text = params.text
        def articleMovements = null
        String textToFind=""
        if (params.containsKey("text")){
            textToFind= params.get("text");
        }else{
            String tipo = params.get("movementType")
            if(!"".equals(params.get("movementType")) && null != params.get("movementType") && !"null".equals(params.get("movementType"))){
                textToFind+="type="+params.get("movementType")+"&"
            }
            if(!"".equals(params.get("startSearch")) && null != params.get("startSearch")){
                textToFind+="start="+params.get("startSearch")+"&"
            }
            if(!"".equals(params.get("endSearch")) && null != params.get("endSearch")){
                textToFind+="end="+params.get("endSearch")
            }
        }
        if(null != textToFind && !"".equals(textToFind)){
            articleMovements = articleMovementService.find(textToFind,10,page)
            siguiente = articleMovementService.find(textToFind,10,page+1)
        }else{
            articleMovements = articleMovementService.find(null,10,page)
            siguiente = articleMovementService.find(null,10,page+1)
        }
        [articleMovementInstanceList: articleMovements, articles: articleService.getAll(), articleMovementInstanceTotal: articleMovements?.size(), page: page, siguiente: siguiente?.size(), text: text, laboratoryInstanceList: laboratoryService.getAll(), textToFind: textToFind,
            user:authService.getName()]
    }

    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_TECNICO'
	])
    def save() {
        def articleMovementInstance = new ArticleMovementB(params)
        articleMovementInstance.setDate(Calendar.getInstance().getTime());
        def article = articleService.getById(Integer.parseInt(params.get("articleId")))
        if(params.get("movementType").equals("SALIDA") && (article.getQuantity() - Integer.valueOf(params.get("quantity"))) < 0){
            flash.error = "Stock insuficiente"
			params.put('articleId' , article?.id)
			params.put('articleName' , article?.name)
			params.put('articleQuantity' , article?.quantity)
            redirect(action: "create", params:params)
        }else{
            articleMovementInstance.setArticle(articleService.getById(Integer.parseInt(params.get("articleId"))))
            articleMovementInstance.setMovementType(MovementTypeEnum.valueOf(params.get("movementType")))
            def newMovementArticle = articleMovementService.save(articleMovementInstance)
            
            redirect(action: "list")
        }
    }
        
    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_TECNICO'
	])
    def download() {
        def text = params.text
        def articleMovements = null
        String textToFind=""
        if (params.containsKey("text")){
            textToFind= params.get("text");
        }else{
            String tipo = params.get("movementType")
            if(!"".equals(params.get("movementType")) && null != params.get("movementType") && !"null".equals(params.get("movementType"))){
                textToFind+="type="+params.get("movementType")+"&"
            }
            if(!"".equals(params.get("startSearch")) && null != params.get("startSearch")){
                textToFind+="start="+params.get("startSearch")+"&"
            }
            if(!"".equals(params.get("endSearch")) && null != params.get("endSearch")){
                textToFind+="end="+params.get("endSearch")
            }
        }
        if(null != textToFind && !"".equals(textToFind)){
            articleMovements = articleMovementService.find(textToFind,0,0)
        }else{
            articleMovements = articleMovementService.find(null,0,0)
        }
                
        String ruta = "Informe Stock.pdf";
        def file = new File(System.getProperty("user.dir") + "\\" + ruta)
        Document documento = new Document(PageSize.A4);
        
        try {
            // Creo las cosas necesarias para el documento
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(System.getProperty("user.dir") + "\\" + ruta));
            // Pongo un evento para que se haga en cada pagina
            writer.setPageEvent(new PageEvent());
            documento.open();
            Font tituloFuente = new Font();
            tituloFuente.setSize(18);
            Paragraph titulo = new Paragraph("Informe de Stock\n", tituloFuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            // Tipo de movimiento
            if(!"".equals(params.get("movementType")) && null != params.get("movementType") && !"null".equals(params.get("movementType"))){
                documento.add(new Phrase("Tipo de movimiento: " + params.get("movementType") + "\n"));
            }else{
                documento.add(new Phrase("Tipo de movimiento: Entrada y Salida\n"));
            }
            if(!"".equals(params.get("startSearch")) && null != params.get("startSearch") && !"null".equals(params.get("startSearch"))){
                documento.add(new Phrase("Fecha de inicio: " + params.get("startSearch") + "\n"));
            }else{
                documento.add(new Phrase("Fecha de inicio: No\n"));
            }
            if(!"".equals(params.get("endSearch")) && null != params.get("endSearch") && !"null".equals(params.get("endSearch"))){
                documento.add(new Phrase("Fecha final: " + params.get("endSearch") + "\n"));
            }else{
                documento.add(new Phrase("Fecha final: No\n"));
            }
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage([240, 120, 120] as float[], new Rectangle(520, 770));
            Font cabeceraf = new Font();
            cabeceraf.setColor(BaseColor.WHITE);
            cabeceraf.setSize(13);
            // Articulo
            PdfPCell cabecerac;
            cabecerac = new PdfPCell(new Phrase("Artículo", cabeceraf));
            cabecerac.setColspan(1);
            cabecerac.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(cabecerac);
            // Diferencia
            cabecerac = new PdfPCell(new Phrase("Diferencia", cabeceraf));
            cabecerac.setColspan(1);
            cabecerac.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(cabecerac);
            // Stock actual
            cabecerac = new PdfPCell(new Phrase("Stock actual", cabeceraf));
            cabecerac.setColspan(1);
            cabecerac.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(cabecerac);
            // Datos
            PdfPCell datosc;
            HashMap<Integer, Integer> lista = new HashMap();
            for(ArticleMovementB am: articleMovements){
                lista.put(am.getArticle().getId(), 0);
            }
            int cantidadActual = 0;
            for(ArticleMovementB am: articleMovements){
                //cantidadActual = lista.get(am.getId().getName());
                cantidadActual = lista.get(am.getArticle().getId());
                if(am.getMovementType() == MovementTypeEnum.ENTRADA){
                    lista.put(am.getArticle().getId(), (cantidadActual + am.getQuantity()));
                    System.out.println("Agregado id: " + am.getArticle().getId())
                }else{
                    lista.put(am.getArticle().getId(), (cantidadActual - am.getQuantity()));
                    System.out.println("Agregado id: " + am.getArticle().getId())
                }
            }
            String nombre = "";
            for(Integer key: lista.keySet()){
                datosc = new PdfPCell(new Phrase(String.valueOf(articleMovementService.getById(key).getArticle().getName())));
                tabla.addCell(datosc);
                
                datosc = new PdfPCell(new Phrase(String.valueOf(lista.get(key))));
                tabla.addCell(datosc);
                
                datosc = new PdfPCell(new Phrase(String.valueOf(articleMovementService.getById(key).getArticle().getQuantity())));
                tabla.addCell(datosc);
            }
            /*for(ArticleMovementB am: articleMovements){
            datosc = new PdfPCell(new Phrase(am.getArticle().getName()));
            tabla.addCell(datosc);
            datosc = new PdfPCell(new Phrase(String.valueOf(am.getQuantity())));
            tabla.addCell(datosc);
            }*/
            
            documento.add(tabla);
            documento.close();
            if (file.exists()){
                render(file: new File(System.getProperty("user.dir") + "\\" + "Informe Stock.pdf"), fileName: 'Informe Stock.pdf', contentType: "application/pdf")
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*@Secured([
    'ROLE_DOCTOR',
    'ROLE_ADMINISTRADOR',
    'ROLE_SECRETARIA'
    ])
    def edit(Long id) {
    def articleMovementInstance = articleMovementService.getById((Integer.parseInt(params.get("id"))))

    [articleInstance: articleMovementInstance,laboratoryInstanceList: laboratoryService.getAll(),
    user:authService.getName()]
    }

    @Secured([
    'ROLE_DOCTOR',
    'ROLE_ADMINISTRADOR',
    'ROLE_SECRETARIA'
    ])
    def update(Long id) {
    def articleMovementInstance = articleMovementService.getById(Integer.parseInt(params.get("edit")))
    System.out.println(articleMovementInstance.getId())
    articleMovementInstance.setName(params.get("name"))
    articleMovementInstance.setDescription(params.get("description"))
    articleMovementInstance.setUnits(params.get("units"))
    articleMovementService.save(articleMovementInstance)
    redirect(action: "list")
    }*/

}

