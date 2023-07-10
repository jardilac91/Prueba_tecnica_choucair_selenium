# Prueba_tecnica_choucair
This project performs diferent Web tests for the page https://exito.com/

The structure used in the project is Screenplay using Java - Serenity and Cucumber.

The flow tested in this project performs a shopping process where the usere selects a category and a subcategory, then select 5 random products with an aleatory quantity and checks if the data of the selected products are equals in the shopping cart.

Sometimes the tests can fail due to a inestability in the product page related with the button to add products, because this button is never deactivate.

To run tests, run the following command

```bash
  gradle clean test
```
