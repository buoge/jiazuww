<#ftl strip_whitespace=true>
<#--
 * Global.ftl
 *
 * @author architect.bian
 * @since 1.0
 -->

<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
<#macro base>
<#if springMacroRequestContext.getContextPath()=="/"><#else>${springMacroRequestContext.getContextPath()}</#if>
</#macro>
<#assign basepath><@base/></#assign>