JPARepositoy:
It has some extra features as compares to Repository interface.
For example, it has a methodpre defined method to find all the records by firtName. We wont have to write queries for things like such.

Allows writing more complex query methods.
We can have custom query methods

1 student has 1 student profile.(1:1 relation)
Here, student profile will have a foreign key and not the student as Student 
can have or have not the student profile, but there should not be a student profile without any student.
So, student profile is a primary entity and student profile is the secondary one.
1 student studies in 1 school. (1:1 relation)
ONe school has zero or many students. (1:M relation)
But a student cannot be without school.



DTO Patter:
It is used to encapsulate data and transfer data from one layer to another.
It  includes simple data fields.

We can have multiple representation for sthe same object and the REST APIs 
should use this representation.
Why do we need this?
1. Data seperation: Allows seperation of Internal domain model to what is exposed to teh world using APIs. Because of this, we can change the 
   internal domain model without affecting what is shown to the world via API.
2. Helps by not exposing sensitive information.
3. Improves perfomance: Instead of sending the whole Paylad, we send whatever is needed by the downstream.
4. Also, whenever we are creating a POST request, sometimes not all the values are present for the payload, so it allows us to send only the data which are  mandatory ones.



Different Layers
Service layer: handles all the business logic. allows code reusability. Helps in creating separation of concerns.
Repository: Data Access layer.
Controller: Presentiation layer.