import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ispClientWeb_state_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/state/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: stateInstance, field: 'country', 'error'))
printHtmlPart(1)
invokeTag('message','g',4,['code':("state.country.label"),'default':("Country")],-1)
printHtmlPart(2)
invokeTag('select','g',7,['id':("country"),'name':("countryId"),'from':(countries),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(stateInstance?.country?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: stateInstance, field: 'name', 'error'))
printHtmlPart(4)
invokeTag('message','g',12,['code':("state.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',15,['name':("name"),'maxlength':("50"),'required':(""),'value':(stateInstance?.name)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1382189077214L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
