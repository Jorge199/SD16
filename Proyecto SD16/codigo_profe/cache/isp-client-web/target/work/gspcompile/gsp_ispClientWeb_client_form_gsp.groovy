import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ispClientWeb_client_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/client/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: clientInstance, field: 'firstName', 'error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("client.firstName.label"),'default':("First Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',7,['name':("firstName"),'maxlength':("50"),'required':(""),'value':(clientInstance?.firstName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: clientInstance, field: 'lastName', 'error'))
printHtmlPart(4)
invokeTag('message','g',12,['code':("client.lastName.label"),'default':("Last Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',15,['name':("lastName"),'maxlength':("50"),'required':(""),'value':(clientInstance?.lastName)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: clientInstance, field: 'document', 'error'))
printHtmlPart(5)
invokeTag('message','g',20,['code':("client.document.label"),'default':("Document")],-1)
printHtmlPart(2)
invokeTag('textField','g',23,['name':("document"),'maxlength':("10"),'required':(""),'value':(clientInstance?.document)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: clientInstance, field: 'city', 'error'))
printHtmlPart(6)
invokeTag('message','g',28,['code':("state.city.label"),'default':("City")],-1)
printHtmlPart(2)
invokeTag('select','g',31,['id':("country"),'name':("cityId"),'from':(cities),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(clientInstance?.city?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1382190527099L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
