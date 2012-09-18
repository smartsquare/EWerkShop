<%@ page import="de.smartsquare.ewerkshop.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'packagedWeightInGramm', 'error')} required">
    <label for="packagedWeightInGramm">
        <g:message code="product.packagedWeightInGramm.label" default="Packaged Weight In Gramm"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="long" name="packagedWeightInGramm" required=""
             value="${fieldValue(bean: productInstance, field: 'packagedWeightInGramm')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'title', 'error')} ">
    <label for="title">
        <g:message code="product.title.label" default="Title"/>

    </label>
    <g:textField name="title" value="${productInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'type', 'error')} required">
    <label for="type">
        <g:message code="product.type.label" default="Type"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="type" name="type.id" from="${de.smartsquare.ewerkshop.ProductType.list()}" optionKey="id"
              optionValue="title" required="" value="${productInstance?.type?.id}" class="many-to-one"/>
</div>
