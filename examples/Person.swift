class Person {
    
    var nombre : String!
    
    
    init(_ nombre : String) {
        self.nombre = nombre
    }
    
}


let person = Person("Alex")

print(person.nombre)
