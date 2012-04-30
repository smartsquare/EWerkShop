
<%@ page import="de.smartsquare.ewerkshop.ProductFactsheet" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productFactsheet.label', default: 'ProductFactsheet')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productFactsheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productFactsheet" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="productId" title="${message(code: 'productFactsheet.productId.label', default: 'Product Id')}" />
					
						<g:sortableColumn property="operatingVoltage" title="${message(code: 'productFactsheet.operatingVoltage.label', default: 'Operating Voltage')}" />
					
						<g:sortableColumn property="powerInput" title="${message(code: 'productFactsheet.powerInput.label', default: 'Power Input')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productFactsheetInstanceList}" status="i" var="productFactsheetInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productFactsheetInstance.id}">${fieldValue(bean: productFactsheetInstance, field: "productId")}</g:link></td>
					
						<td>${fieldValue(bean: productFactsheetInstance, field: "operatingVoltage")}</td>
					
						<td>${fieldValue(bean: productFactsheetInstance, field: "powerInput")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productFactsheetInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
