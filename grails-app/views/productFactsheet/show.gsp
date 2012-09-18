<%@ page import="de.smartsquare.ewerkshop.ProductFactsheet" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'productFactsheet.label', default: 'ProductFactsheet')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-productFactsheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                       default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-productFactsheet" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list productFactsheet">

        <g:if test="${productFactsheetInstance?.productId}">
            <li class="fieldcontain">
                <span id="productId-label" class="property-label"><g:message code="productFactsheet.productId.label"
                                                                             default="Product Id"/></span>

                <span class="property-value" aria-labelledby="productId-label"><g:fieldValue
                        bean="${productFactsheetInstance}" field="productId"/></span>

            </li>
        </g:if>
        </g:if>

        <g:if test="${productFactsheetInstance?.operatingVoltage}">
            <li class="fieldcontain">
                <span id="operatingVoltage-label" class="property-label"><g:message
                        code="productFactsheet.operatingVoltage.label" default="Operating Voltage"/></span>

                <span class="property-value" aria-labelledby="operatingVoltage-label"><g:fieldValue
                        bean="${productFactsheetInstance}" field="operatingVoltage"/></span>

            </li>
        </g:if>

        <g:if test="${productFactsheetInstance?.powerInput}">
            <li class="fieldcontain">
                <span id="powerInput-label" class="property-label"><g:message code="productFactsheet.powerInput.label"
                                                                              default="Power Input"/></span>

                <span class="property-value" aria-labelledby="powerInput-label"><g:fieldValue
                        bean="${productFactsheetInstance}" field="powerInput"/></span>

            </li>
        </g:if>

        <g:if test="${productFactsheetInstance['dynBladeLength']}">
            <li class="fieldcontain">
                <span id="bladeLength-label" class="property-label"><g:message
                        code="productFactsheet.dynBladeLength.label" default="Blade Length"/></span>

                <span class="property-value"
                      aria-labelledby="bladeLength-label">${productFactsheetInstance['dynBladeLength']}</span>

            </li>
        </g:if>

        <g:if test="${productFactsheetInstance['dynBladeDiameter']}">
            <li class="fieldcontain">
                <span id="bladeDiameter-label" class="property-label"><g:message
                        code="productFactsheet.dynBladeDiameter.label" default="Blade Diameter"/></span>

                <span class="property-value"
                      aria-labelledby="bladeDiameter-label">${productFactsheetInstance['dynBladeDiameter']}</span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${productFactsheetInstance?.id}"/>
            <g:link class="edit" action="edit" id="${productFactsheetInstance?.id}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
