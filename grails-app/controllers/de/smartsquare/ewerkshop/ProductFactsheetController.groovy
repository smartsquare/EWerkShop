package de.smartsquare.ewerkshop

import org.springframework.dao.DataIntegrityViolationException

class ProductFactsheetController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [productFactsheetInstanceList: ProductFactsheet.list(params), productFactsheetInstanceTotal: ProductFactsheet.count()]
    }

    def create() {
        [productFactsheetInstance: new ProductFactsheet(params)]
    }

    def save() {
        def productFactsheetInstance = new ProductFactsheet(params)
        if (!productFactsheetInstance.save(flush: true)) {
            render(view: "create", model: [productFactsheetInstance: productFactsheetInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), productFactsheetInstance.id])
        redirect(action: "show", id: productFactsheetInstance.id)
    }

    def show() {
        def productFactsheetInstance = ProductFactsheet.get(params.id)
        if (!productFactsheetInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), params.id])
            redirect(action: "list")
            return
        }

        [productFactsheetInstance: productFactsheetInstance]
    }

    def edit() {
        def productFactsheetInstance = ProductFactsheet.get(params.id)
        if (!productFactsheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), params.id])
            redirect(action: "list")
            return
        }

        [productFactsheetInstance: productFactsheetInstance]
    }

    def update() {
        def productFactsheetInstance = ProductFactsheet.get(params.id)
        if (!productFactsheetInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (productFactsheetInstance.version > version) {
                productFactsheetInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'productFactsheet.label', default: 'ProductFactsheet')] as Object[],
                          "Another user has updated this ProductFactsheet while you were editing")
                render(view: "edit", model: [productFactsheetInstance: productFactsheetInstance])
                return
            }
        }

        productFactsheetInstance.properties = params

        if (!productFactsheetInstance.save(flush: true)) {
            render(view: "edit", model: [productFactsheetInstance: productFactsheetInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), productFactsheetInstance.id])
        redirect(action: "show", id: productFactsheetInstance.id)
    }

    def delete() {
        def productFactsheetInstance = ProductFactsheet.get(params.id)
        if (!productFactsheetInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), params.id])
            redirect(action: "list")
            return
        }

        try {
            productFactsheetInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'productFactsheet.label', default: 'ProductFactsheet'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
