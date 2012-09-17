package de.smartsquare.ewerkshop



import org.junit.*
import grails.test.mixin.*

@TestFor(ProductTypeController)
@Mock(ProductType)
class ProductTypeControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/productType/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productTypeInstanceList.size() == 0
        assert model.productTypeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.productTypeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productTypeInstance != null
        assert view == '/productType/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/productType/show/1'
        assert controller.flash.message != null
        assert ProductType.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/productType/list'


        populateValidParams(params)
        def productType = new ProductType(params)

        assert productType.save() != null

        params.id = productType.id

        def model = controller.show()

        assert model.productTypeInstance == productType
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/productType/list'


        populateValidParams(params)
        def productType = new ProductType(params)

        assert productType.save() != null

        params.id = productType.id

        def model = controller.edit()

        assert model.productTypeInstance == productType
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/productType/list'

        response.reset()


        populateValidParams(params)
        def productType = new ProductType(params)

        assert productType.save() != null

        // test invalid parameters in update
        params.id = productType.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/productType/edit"
        assert model.productTypeInstance != null

        productType.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/productType/show/$productType.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        productType.clearErrors()

        populateValidParams(params)
        params.id = productType.id
        params.version = -1
        controller.update()

        assert view == "/productType/edit"
        assert model.productTypeInstance != null
        assert model.productTypeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/productType/list'

        response.reset()

        populateValidParams(params)
        def productType = new ProductType(params)

        assert productType.save() != null
        assert ProductType.count() == 1

        params.id = productType.id

        controller.delete()

        assert ProductType.count() == 0
        assert ProductType.get(productType.id) == null
        assert response.redirectedUrl == '/productType/list'
    }
}
