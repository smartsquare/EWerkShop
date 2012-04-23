import de.smartsquare.ewerkshop.*

class BootStrap {

    def init = { servletContext ->
        ProductType typeStichsaege = new ProductType(title: 'Stichsäge')
    	typeStichsaege.save()
        ProductType typeKreissaege = new ProductType(title: 'Kreisssäge')
    	typeKreissaege.save()
    	
    	Product stichsaege = new Product(title: 'Stichi 6001', type: typeStichsaege, packagedWeightInGramm: 650)
    	stichsaege.save()
    	Product kreissaege = new Product(title: 'Kreisi Mega-X', type: typeKreissaege, packagedWeightInGramm: 1890)
    	kreissaege.save()
    }
    def destroy = {
    }
}
