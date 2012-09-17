package de.smartsquare.ewerkshop



import org.junit.*
import grails.test.mixin.*

@TestFor(ProductFactsheetController)
@Mock(ProductFactsheet)
class ProductFactsheetControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/productFactsheet/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productFactsheetInstanceList.size() == 0
        assert model.productFactsheetInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.productFactsheetInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productFactsheetInstance != null
        assert view == '/productFactsheet/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/productFactsheet/show/1'
        assert controller.flash.message != null
        assert ProductFactsheet.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/productFactsheet/list'


        populateValidParams(params)
        def productFactsheet = new ProductFactsheet(params)

        assert productFactsheet.save() != null

        params.id = productFactsheet.id

        def model = controller.show()

        assert model.productFactsheetInstance == productFactsheet
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/productFactsheet/list'


        populateValidParams(params)
        def productFactsheet = new ProductFactsheet(params)

        assert productFactsheet.save() != null

        params.id = productFactsheet.id

        def model = controller.edit()

        assert model.productFactsheetInstance == productFactsheet
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/productFactsheet/list'

        response.reset()


        populateValidParams(params)
        def productFactsheet = new ProductFactsheet(params)

        assert productFactsheet.save() != null

        // test invalid parameters in update
        params.id = productFactsheet.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/productFactsheet/edit"
        assert model.productFactsheetInstance != null

        productFactsheet.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/productFactsheet/show/$productFactsheet.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        productFactsheet.clearErrors()

        populateValidParams(params)
        params.id = productFactsheet.id
        params.version = -1
        controller.update()

        assert view == "/productFactsheet/edit"
        assert model.productFactsheetInstance != null
        assert model.productFactsheetInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/productFactsheet/list'

        response.reset()

        populateValidParams(params)
        def productFactsheet = new ProductFactsheet(params)

        assert productFactsheet.save() != null
        assert ProductFactsheet.count() == 1

        params.id = productFactsheet.id

        controller.delete()

        assert ProductFactsheet.count() == 0
        assert ProductFactsheet.get(productFactsheet.id) == null
        assert response.redirectedUrl == '/productFactsheet/list'
    }
}
