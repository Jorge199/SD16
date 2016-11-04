import com.sd.isp.city.City
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ispClientWeb_citylist_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/city/list.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(0)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'city.label', default: 'City'))],-1)
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('message','g',13,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(3)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(4)
invokeTag('message','g',17,['code':("default.home.label")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',19,['code':("default.new.label"),'args':([entityName])],-1)
printHtmlPart(7)
})
invokeTag('link','g',20,['class':("create"),'action':("create")],2)
printHtmlPart(8)
invokeTag('message','g',25,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('sortableColumn','g',37,['property':("name"),'title':(message(code: 'city.name.label', default: 'Name'))],-1)
printHtmlPart(13)
invokeTag('message','g',39,['code':("city.state.label"),'default':("State")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( cityInstance in (cityInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(fieldValue(bean: cityInstance, field: "name"))
printHtmlPart(18)
})
invokeTag('link','g',49,['action':("show"),'id':(cityInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: cityInstance, field: "state.name"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: cityInstance, field: "country.name"))
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',62,['total':(cityInstanceTotal)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1382189718279L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
