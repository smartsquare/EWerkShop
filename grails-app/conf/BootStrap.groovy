import de.smartsquare.ewerkshop.*

class BootStrap {

    def init = { servletContext ->
        ProductType typeStichsaege = new ProductType(title: 'Stichsäge')
    	typeStichsaege.save()
        ProductType typeKreissaege = new ProductType(title: 'Kreisssäge')
    	typeKreissaege.save()
    	
    	Product stichsaege = new Product(title: 'Stichi 6001', type: typeStichsaege, packagedWeightInGramm: 650)
    	stichsaege.save()
    	Product kreissaege1 = new Product(title: 'Kreisi 3000', type: typeKreissaege, packagedWeightInGramm: 1430)
        kreissaege1.save()
        Product kreissaege2 = new Product(title: 'Kreisi Mega-X', type: typeKreissaege, packagedWeightInGramm: 1890)
        kreissaege2.save()

        ProductFactsheet.collection.getDB().dropDatabase()

    	ProductFactsheet factsStichsaege = new ProductFactsheet(productId: stichsaege.getId(), operatingVoltage: 220, powerInput: 400)
    	factsStichsaege['dynBladeLength'] = 8
    	factsStichsaege.save()

    	ProductFactsheet factsKreissaege = new ProductFactsheet(productId: kreissaege2.getId(), operatingVoltage: 220, powerInput: 1200)
    	factsKreissaege['dynBladeDiameter'] = 35
    	factsKreissaege.save()
    }
    def destroy = {
    }
}
