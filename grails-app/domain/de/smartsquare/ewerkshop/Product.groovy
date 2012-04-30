package de.smartsquare.ewerkshop

class Product {
	String title
	Long packagedWeightInGramm
	ProductType type
	
	ProductFactsheet getFactsheet() {
	    return ProductFactsheet.find(this.getId())
    }
}
