import com.sd.isp.city.City
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ispClientWeb_city_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/city/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: cityInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("city.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("50"),'required':(""),'value':(cityInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: cityInstance, field: 'state', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("city.state.label"),'default':("State")],-1)
printHtmlPart(2)
invokeTag('select','g',18,['id':("state"),'name':("stateId"),'from':(states),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(cityInstance?.state?.id),'class':("many-to-one")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1382193045345L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
