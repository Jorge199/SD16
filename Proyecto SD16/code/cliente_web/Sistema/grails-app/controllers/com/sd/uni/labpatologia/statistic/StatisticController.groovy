package com.sd.uni.labpatologia.statistic

import org.springframework.beans.factory.annotation.Autowired;

import com.sd.uni.labpatologia.beans.diagnostic.DiagnosticB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.service.statistic.IStatisticService;
import com.sd.uni.labpatologia.service.diagnostic.IDiagnosticService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
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
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.awt.DefaultFontMapper;
import java.util.HashMap

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.sd.uni.labpatologia.utils.PageEvent;

import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.CategoryAxis;

import grails.plugin.springsecurity.annotation.Secured;

class StatisticController {

    def ILaboratoryService laboratoryService
    def IStatisticService statisticService
    def IDiagnosticService diagnosticService
	
    @Autowired def IAuthService authService
    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
    def index() {
        redirect(action: "list",params: params)
    }

    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
    def list() {
        def statistics = null
        def diagnostic = ""
        def startAge = ""
        def endAge = ""
        def sex = ""
        def startSearch = ""
        def endSearch = ""
        def data = [getByDate: 'false', getByDiagnostic: 'false', getByPatientAge: 'false', getBySex:'false']
        String textToFind=""
        if(null!=params.get("diagnosticSearch") && !"".equals(params.get("diagnosticSearch")) && !"null".equals(params.get("diagnosticSearch"))){
            diagnostic = params.get("diagnosticSearch")
            textToFind+="diagnostic="+params.get("diagnosticSearch")+'&'
            data.put("getByDiagnostic", params.get("diagnosticSearch"))
        }
        if((!"".equals(params.get("startSearch"))) && !"".equals(params.get("endSearch")) && (null != params.get("startSearch")) && (null != params.get("endSearch"))){
            startSearch = params.get("startSearch")
            endSearch = params.get("endSearch")
            textToFind+="start="+params.get("startSearch")+'&'
            textToFind+="end="+params.get("endSearch")+'&'
            data.put("getByDate", "true")
            data.put("startDate", params.get("startSearch"))
            data.put("endDate", params.get("endSearch"))
        }

        if((!"".equals(params.get("startAge"))) && !"".equals(params.get("endAge")) && (null != params.get("startAge")) && (null != params.get("endAge"))){
            startAge = params.get("startAge")
            endAge = params.get("endAge")
            textToFind+="startAge="+params.get("startAge")+'&'
            textToFind+="endAge="+params.get("endAge")+'&'
            data.put("getByPatientAge", "true")
            data.put("startAge", params.get("startAge"))
            data.put("endAge", params.get("endAge"))
        }
        if(null!=params.get("sex") && !"".equals(params.get("sex")) && !"null".equals(params.get("sex"))){
            sex = params.get("sex")
            textToFind+="sex="+params.get("sex")
            data.put("getBySex", params.get("sex"))
        }
		
        //Si la consulta no esta vacia
        if(!textToFind.equals("")){
            System.out.println(textToFind)
            System.out.println(data)
            System.out.println(params)
			
            //Si no especifica el sexo entonces busca todos los sexos
            if(data.get("getBySex")=='false'){
                int totalSex=0
                statistics = statisticService.find("sex=MASCULINO&"+textToFind)
                data.put("masculino", statistics.size())
                totalSex+=statistics.size()

                statistics = statisticService.find("sex=FEMENINO&"+textToFind)
                data.put("femenino", statistics.size())
                totalSex+=statistics.size()

                data.put("totalSex",totalSex)
            }
            //Si no especifica un diagnostico entonces busca todos los diagnosticos
            if(data.get("getByDiagnostic")=='false'){
                int totalDiagnostic=0
                for( DiagnosticB diagnosticFor in diagnosticService.getAll()){
                    data.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()+'&'+textToFind).size())
                    totalDiagnostic+=data.get(diagnosticFor.getName())
                }
                data.put("totalDiagnostic", totalDiagnostic)
            }else{
                int totalDiagnostic=0
                String diagnosticTextToFind = ""
                if(textToFind.indexOf('&')+1==textToFind.length()){
                    diagnosticTextToFind=""
                }else{
                    diagnosticTextToFind=textToFind.substring(textToFind.indexOf('&')+1,textToFind.length())
                }
                for(DiagnosticB diagnosticFor in diagnosticService.getAll()){
                    if(data.get("getByDiagnostic")==diagnosticFor.getName()){
                        data.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()+'&'+diagnosticTextToFind).size())
                        System.out.println(diagnosticFor.getName() + " " + data.get(diagnosticFor.getName()))
                    }
                    totalDiagnostic+=statisticService.find("diagnostic="+diagnosticFor.getName()+'&'+diagnosticTextToFind).size()
                }
                data.put("totalDiagnostic", totalDiagnostic)
				
            }
            statistics = statisticService.find(textToFind)
        }else{
            //Si esta vacio entonces obtiene todas las cantidades de diagnosticos y sexos de todos los tiempos
            int totalSex=0, totalDiagnostic = 0

            //Para sexo
            statistics = statisticService.find("sex=MASCULINO")
            data.put("masculino", statistics.size())
            totalSex+=statistics.size()

            statistics = statisticService.find("sex=FEMENINO")
            data.put("femenino", statistics.size())
            totalSex+=statistics.size()

            data.put("totalSex",totalSex)

            //Para Diagnóstico
            for( DiagnosticB diagnosticFor in diagnosticService.getAll()){
                data.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()).size())
                totalDiagnostic+=data.get(diagnosticFor.getName())
            }
            data.put("totalDiagnostic", totalDiagnostic)
        }
        [user:authService.getName(), laboratoryInstanceList: laboratoryService.getAll(), dataMap: data, diagnosticSearch: params.get("diagnosticSearch"), startAge: startAge, endAge: endAge, sex: sex, startSearch: startSearch, endSearch: endSearch ]
    }
        
    @Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
        ])
    def download() {
        def par = params
        def statistics = null
        def diagnostic = ""
        def startAge = ""
        def endAge = ""
        def sex = ""
        def startSearch = ""
        def endSearch = ""
        def diagnosticos = new HashMap()
        def data = [getByDate: 'false', getByDiagnostic: 'false', getByPatientAge: 'false', getBySex:'false']
        String textToFind=""
        if(null!=params.get("diagnosticSearch") && !"".equals(params.get("diagnosticSearch")) && !"null".equals(params.get("diagnosticSearch"))){
            diagnostic = params.get("diagnosticSearch")
            textToFind+="diagnostic="+params.get("diagnosticSearch")+'&'
            data.put("getByDiagnostic", params.get("diagnosticSearch"))
        }
        if((!"".equals(params.get("startSearch"))) && !"".equals(params.get("endSearch")) && (null != params.get("startSearch")) && (null != params.get("endSearch"))){
            startSearch = params.get("startSearch")
            endSearch = params.get("endSearch")
            textToFind+="start="+params.get("startSearch")+'&'
            textToFind+="end="+params.get("endSearch")+'&'
            data.put("getByDate", "true")
            data.put("startDate", params.get("startSearch"))
            data.put("endDate", params.get("endSearch"))
        }

        if((!"".equals(params.get("startAge"))) && !"".equals(params.get("endAge")) && (null != params.get("startAge")) && (null != params.get("endAge"))){
            startAge = params.get("startAge")
            endAge = params.get("endAge")
            textToFind+="startAge="+params.get("startAge")+'&'
            textToFind+="endAge="+params.get("endAge")+'&'
            data.put("getByPatientAge", "true")
            data.put("startAge", params.get("startAge"))
            data.put("endAge", params.get("endAge"))
        }
        if(null!=params.get("sex") && !"".equals(params.get("sex")) && !"null".equals(params.get("sex"))){
            sex = params.get("sex")
            textToFind+="sex="+params.get("sex")
            data.put("getBySex", params.get("sex"))
        }
		
        //Si la consulta no esta vacia
        if(!textToFind.equals("")){
            System.out.println(textToFind)
            System.out.println(data)
            System.out.println(params)
			
            //Si no especifica el sexo entonces busca todos los sexos
            if(data.get("getBySex")=='false'){
                int totalSex=0
                statistics = statisticService.find("sex=MASCULINO&"+textToFind)
                data.put("masculino", statistics.size())
                totalSex+=statistics.size()

                statistics = statisticService.find("sex=FEMENINO&"+textToFind)
                data.put("femenino", statistics.size())
                totalSex+=statistics.size()

                data.put("totalSex",totalSex)
            }
            //Si no especifica un diagnostico entonces busca todos los diagnosticos
            if(data.get("getByDiagnostic")=='false'){
                int totalDiagnostic=0
                for( DiagnosticB diagnosticFor in diagnosticService.getAll()){
                    data.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()+'&'+textToFind).size())
                    totalDiagnostic+=data.get(diagnosticFor.getName())
                }
                data.put("totalDiagnostic", totalDiagnostic)
            }else{
                int totalDiagnostic=0
                String diagnosticTextToFind = ""
                if(textToFind.indexOf('&')+1==textToFind.length()){
                    diagnosticTextToFind=""
                }else{
                    diagnosticTextToFind=textToFind.substring(textToFind.indexOf('&')+1,textToFind.length())
                }
                for(DiagnosticB diagnosticFor in diagnosticService.getAll()){
                    if(data.get("getByDiagnostic")==diagnosticFor.getName()){
                        data.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()+'&'+diagnosticTextToFind).size())
                        System.out.println(diagnosticFor.getName() + " " + data.get(diagnosticFor.getName()))
                    }
                    totalDiagnostic+=statisticService.find("diagnostic="+diagnosticFor.getName()+'&'+diagnosticTextToFind).size()
                }
                data.put("totalDiagnostic", totalDiagnostic)
				
            }
            statistics = statisticService.find(textToFind)
        }else{
            //Si esta vacio entonces obtiene todas las cantidades de diagnosticos y sexos de todos los tiempos
            int totalSex=0, totalDiagnostic = 0

            //Para sexo
            statistics = statisticService.find("sex=MASCULINO")
            data.put("masculino", statistics.size())
            totalSex+=statistics.size()

            statistics = statisticService.find("sex=FEMENINO")
            data.put("femenino", statistics.size())
            totalSex+=statistics.size()

            data.put("totalSex",totalSex)

            //Para Diagnóstico
            for( DiagnosticB diagnosticFor in diagnosticService.getAll()){
                data.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()).size())
                diagnosticos.put(diagnosticFor.getName(), statisticService.find("diagnostic="+diagnosticFor.getName()).size())
                totalDiagnostic+=data.get(diagnosticFor.getName())
            }
            data.put("totalDiagnostic", totalDiagnostic)
        }
        
        
        String ruta = "Estadisticas.pdf";
        DecimalFormat df = new DecimalFormat("#.##");
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
            Paragraph titulo = new Paragraph("Informe de estadísticas", tituloFuente);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            if(data.get("getByDiagnostic") != 'false'){
                documento.add(new Phrase("Diagnostico: " + data.get("getByDiagnostic")+ "\n"));
            }else{
                documento.add(new Phrase("Diagnostico: Todos\n"));
            }
            if(data.get("getByPatientAge") != 'false'){
                documento.add(new Phrase("Edad: " + data.get("startAge") + " a " + data.get("endAge") + " años\n"));
            }else{
                documento.add(new Phrase("Edad: Todos\n"));
            }
            if(data.get("getBySex") != 'false'){
                documento.add(new Phrase("Sexo: " + data.get("getBySex") + "\n"));
            }else{
                documento.add(new Phrase("Sexo: Ambos\n"));
            }
            if(data.get("getByDate") == 'true'){
                documento.add(new Phrase("Fechas: " + data.get("startDate") + "  -  " + data.get("endDate") + "\n\n"));
            }else{
                documento.add(new Phrase("Fechas: Sin especificar\n\n"));
            }
            def total = data.get("totalDiagnostic");
            if(data.get("getByDiagnostic") != 'false'){
                def cantidad = data.get(data.get("getByDiagnostic"));
                if(cantidad == null){
                    return
                }
                double promedio = 0;
                if(data.get("totalDiagnostic") != 0){
                    promedio = cantidad.div(total);
                    promedio = promedio*100;
                }
                documento.add(new Phrase("Se observan " + data.get(data.get("getByDiagnostic")) + " casos, que representan el " + df.format(promedio) + " % de los casos registrados en el laboratorio en ese periodo."));
            }
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage([240, 120, 120] as float[], new Rectangle(520, 770));
            Font cabeceraf = new Font();
            cabeceraf.setColor(BaseColor.WHITE);
            cabeceraf.setSize(13);
            // Diagnostico
            PdfPCell cabecerac;
            cabecerac = new PdfPCell(new Phrase("Diagnostico", cabeceraf));
            cabecerac.setColspan(1);
            cabecerac.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(cabecerac);
            // Cantidad
            cabecerac = new PdfPCell(new Phrase("Cantidad", cabeceraf));
            cabecerac.setColspan(1);
            cabecerac.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(cabecerac);
            // Porcentaje
            cabecerac = new PdfPCell(new Phrase("Porcentaje", cabeceraf));
            cabecerac.setColspan(1);
            cabecerac.setBackgroundColor(BaseColor.DARK_GRAY);
            tabla.addCell(cabecerac);
            // Datos
            PdfPCell datosc;
            JFreeChart chart;
            
            if(data.get("getByDiagnostic") == 'false'){
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                Iterator it = diagnosticos.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    datosc = new PdfPCell(new Phrase(pair.getKey()));
                    tabla.addCell(datosc);
                    def cantidad2 = pair.getValue();
                    double porcentaje = (double)cantidad2.div(total) * 100;
                    tabla.addCell(new Phrase(String.valueOf(cantidad2)));
                    datosc = new PdfPCell(new Phrase(df.format(porcentaje)));
                    tabla.addCell(datosc);
                    dataSet.setValue(cantidad2, "Cantidad", pair.getKey());
                    System.out.println(pair.getKey() + " = " + pair.getValue());
                    it.remove(); // avoids a ConcurrentModificationException
                }
                /for(DiagnosticEnum diagnostic in DiagnosticEnum.values()){
                    datosc = new PdfPCell(new Phrase(diagnostic.getKey()));
                    tabla.addCell(datosc);
                    def cantidad2 = data.get(diagnostic.getKey().toString());
                    double porcentaje = (double)cantidad2.div(total) * 100;
                    tabla.addCell(new Phrase(String.valueOf(cantidad2)));
                    datosc = new PdfPCell(new Phrase(df.format(porcentaje)));
                    tabla.addCell(datosc);
                    dataSet.setValue(cantidad2, "Cantidad", diagnostic.getKey());
                }/
                datosc = new PdfPCell(new Phrase("Total: "));
                datosc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(datosc);
                datosc = new PdfPCell(new Phrase(String.valueOf(total)));
                datosc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(datosc);
                datosc = new PdfPCell(new Phrase(""));
                datosc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(datosc);
                documento.add(tabla);
                
		/chart = ChartFactory.createBarChart(
				"", "Diagnósticos", "Cantidad",
				dataSet, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot plot = chart.getCategoryPlot();
                CategoryAxis axis = plot.getDomainAxis();
                axis.setTickLabelFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 8));
                writeChartToPDF(chart, 500, 300, documento, writer);/
            }else{
                datosc = new PdfPCell(new Phrase(data.get("getByDiagnostic")));
                tabla.addCell(datosc);
                def cantidad2 = data.get(data.get("getByDiagnostic"));
                if(total != 0){
                    double porcentaje = (double)cantidad2.div(total) * 100;
                    tabla.addCell(new Phrase(String.valueOf(cantidad2)));
                    datosc = new PdfPCell(new Phrase(df.format(porcentaje)));
                    tabla.addCell(datosc);
                }else{
                    double porcentaje = 0.0
                    tabla.addCell(new Phrase(String.valueOf(cantidad2)));
                    datosc = new PdfPCell(new Phrase(df.format(porcentaje)));
                    tabla.addCell(datosc);
                }
                    
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
                dataSet.setValue(cantidad2, "Cantidad", data.get("getByDiagnostic"));
                dataSet.setValue(total - cantidad2, "Cantidad", "Otros");
                
                datosc = new PdfPCell(new Phrase("Total: "));
                datosc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(datosc);
                datosc = new PdfPCell(new Phrase(String.valueOf(total)));
                datosc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(datosc);
                datosc = new PdfPCell(new Phrase(""));
                datosc.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(datosc);
                documento.add(tabla);
                
		/chart = ChartFactory.createBarChart(
				"", "Diagnósticos", "Cantidad",
				dataSet, PlotOrientation.VERTICAL, false, true, false);
                
                CategoryPlot plot = chart.getCategoryPlot();
                CategoryAxis axis = plot.getDomainAxis();
                axis.setTickLabelFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 8));
                writeChartToPDF(chart, 240, 300, documento, writer);/
            }
            
            //writeChartToPDF(generateBarChart(), 500, 300, documento, writer);
            documento.close();
            if (file.exists()){
                render(file: new File(System.getProperty("user.dir") + "\\" + "Estadisticas.pdf"), fileName: 'Estadisticas.pdf', contentType: "application/pdf")
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static JFreeChart generateBarChart() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(791, "Population", "1750 AD");
        dataSet.setValue(978, "Population", "1800 AD");
        dataSet.setValue(1262, "Population", "1850 AD");
        dataSet.setValue(1650, "Population", "1900 AD");
        dataSet.setValue(2519, "Population", "1950 AD");
        dataSet.setValue(6070, "Population", "2000 AD");

        JFreeChart chart = ChartFactory.createBarChart(
				"World Population growth", "Year", "Population in millions",
            dataSet, PlotOrientation.VERTICAL, false, true, false);

        return chart;
    }
    
    public static void writeChartToPDF(JFreeChart chart, int width, int height, Document document, PdfWriter writer) {

        try {
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(width, height);
            Graphics2D graphics2d = template.createGraphics(width, height,
                new DefaultFontMapper());
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
                height);

            chart.draw(graphics2d, rectangle2d);
			
            graphics2d.dispose();
            contentByte.addTemplate(template, 40, 200);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
