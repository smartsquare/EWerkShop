<%@ page import="de.smartsquare.ewerkshop.ProductFactsheet" %>



<div class="fieldcontain ${hasErrors(bean: productFactsheetInstance, field: 'productId', 'error')} required">
	<label for="productId">
		<g:message code="productFactsheet.productId.label" default="Product Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field readonly="Y" type="number" name="productId" required="" value="${fieldValue(bean: productFactsheetInstance, field: 'productId')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productFactsheetInstance, field: 'operatingVoltage', 'error')} required">
	<label for="operatingVoltage">
		<g:message code="productFactsheet.operatingVoltage.label" default="Operating Voltage" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="long" name="operatingVoltage" required="" value="${fieldValue(bean: productFactsheetInstance, field: 'operatingVoltage')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productFactsheetInstance, field: 'powerInput', 'error')} required">
	<label for="powerInput">
		<g:message code="productFactsheet.powerInput.label" default="Power Input" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="long" name="powerInput" required="" value="${fieldValue(bean: productFactsheetInstance, field: 'powerInput')}"/>
</div>

<div class="fieldcontain">
	<label for="dynBladeLength">
		<g:message code="productFactsheet.dynBladeLength.label" default="Blade Length" />
	</label>
	<g:field type="long" name="dynBladeLength" value="${productFactsheetInstance?.isAttached() ? productFactsheetInstance?.getAt('dynBladeLength') : null}"/>
</div>

<div class="fieldcontain">
	<label for="dynBladeDiameter">
		<g:message code="productFactsheet.dynBladeDiameter.label" default="Blade Diameter" />
	</label>
	<g:field type="long" name="dynBladeDiameter" value="${productFactsheetInstance?.isAttached() ? productFactsheetInstance?.getAt('dynBladeDiameter') : null}"/>
</div>
