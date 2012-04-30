<%@ page import="de.smartsquare.ewerkshop.ProductFactsheet" %>



<div class="fieldcontain ${hasErrors(bean: productFactsheetInstance, field: 'productId', 'error')} required">
	<label for="productId">
		<g:message code="productFactsheet.productId.label" default="Product Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="productId" required="" value="${fieldValue(bean: productFactsheetInstance, field: 'productId')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productFactsheetInstance, field: 'operatingVoltage', 'error')} required">
	<label for="operatingVoltage">
		<g:message code="productFactsheet.operatingVoltage.label" default="Operating Voltage" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="operatingVoltage" required="" value="${fieldValue(bean: productFactsheetInstance, field: 'operatingVoltage')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productFactsheetInstance, field: 'powerInput', 'error')} required">
	<label for="powerInput">
		<g:message code="productFactsheet.powerInput.label" default="Power Input" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="powerInput" required="" value="${fieldValue(bean: productFactsheetInstance, field: 'powerInput')}"/>
</div>

