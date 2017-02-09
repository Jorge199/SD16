/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Alex Jiñes
 */
public class PageEvent extends PdfPageEventHelper{
    
    @Override
    public void onStartPage(PdfWriter writer, Document document){
        SimpleDateFormat formatoFechaBarra = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Font f = new Font();
        f.setColor(BaseColor.LIGHT_GRAY);
        f.setSize(9);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(formatoFechaBarra.format(Calendar.getInstance().getTime()), f), 550, 800, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(formatoHora.format(Calendar.getInstance().getTime()), f), 550, 790, 0);
    }
}
