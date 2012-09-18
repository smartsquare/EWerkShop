<%@ page import="de.smartsquare.ewerkshop.ProductType" %>



<div class="fieldcontain ${hasErrors(bean: productTypeInstance, field: 'title', 'error')} ">
    <label for="title">
        <g:message code="productType.title.label" default="Title"/>

    </label>
    <g:textField name="title" value="${productTypeInstance?.title}"/>
</div>

