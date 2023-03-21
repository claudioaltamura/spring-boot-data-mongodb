db = db.getSiblingDB('admin');

db.auth("root", "admin");

db = db.getSiblingDB('product_materials_db');

db.createUser({
'user': "productMaterialApp",
'pwd': "1234",
'roles': [{
    'role': 'dbOwner',
    'db': 'product_materials_db'}]});

db.createCollection('product_materials');

db.product_materials.insert( {
    materialNumber : "ABN123" ,
    name : "ABN123 Product" ,
    description : "New Product",
    price : 10.3
});
