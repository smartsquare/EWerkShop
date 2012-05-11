package de.smartsquare.ewerkshop

class ProductFactsheet {
    static mapWith = "mongo"
    
    Long productId
    Long operatingVoltage
    Long powerInput
    
    static constraints = {
        productId unique: true
		operatingVoltage min: 110l, max: 230l
    }
}
