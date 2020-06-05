# REST-Api-with-Spring-Boot
This small project show 3 different approach : Using Hibernate, Standard JPA, Spring Data JPA

The Goal of this is to choose what ever Implementation and DAO techniques you want to use based on your project demands

1st Project is made using EntityManager but leverage native Hibernate API
</br>
2nd Project use EntityManager and Standard JPA Api
</br>
3rd Spring Data JPA
</br>
4st Spring Data Rest
</br>

JPA provide standard API, so you are not lock to any vendor and you can switch between them, also makes you mainting portable, flexible code and support query language : JPQL (java persistence query language)   
</br>
The use of JPA Api methods is very similar to native hibernate Api :
    
<table>
  <tr>
    <th>Action</th>
    <th>Hibernate Methods</th>
    <th>JPA Methods</th>
  </tr>
  
  <tr>
    <th>Create/Save new Entity</th>
    <th>session.save(...)</th>
    <th>entityManager.persist(...)</th>
  </tr>
  
  <tr>
    <th>Retrieve Entity by Id</th>
    <th>session.get(...)/load(...)</th>
    <th>entityManager.find(...)</th>
  </tr>
  
  <tr>
    <th>Retrieve list of Entities</th>
    <th>session.createQuery(...)</th>
    <th>entityManager.createQuery(...)</th>
  </tr>
  
  <tr>
    <th>Save or Update Entity</th>
    <th>session.saveOrUpdate(...)</th>
    <th>entityManager.merge(...)</th>
  </tr>
  
  <tr>
    <th>Delete Entity</th>
    <th>session.delete(...)</th>
    <th>entityManager.remove(...)</th>
  </tr>
  
</table>

Each one of them have benefits and downside: for example if i want to create a DAO for another entity, we have to repeat all the same code again, following the same pattern.
</br>
This practice is not recommended for CRUD Rest Api, so Spring Data JPA came with a solution, by providing CRUD methods and plug it for each entity, using entity type and primary key.
</br>
Spring Data JPA provides the interface CRUDRepository, which exposes methods(some by inheritance from parents) and support some advanced features:
    <li>Extending and adding custom queries with JPQL</li>
    <li>Query Domain specific language(Query DSL)</li>
    <li>Defining custom methods</li>
</br>
Method and description provided :
<ul>
<li>count() : Returns the number of entities available.</li>
<li>delete(T entity) : Deletes a given entity.</li>
<li>deleteAll() : Deletes all entities managed by the repository.</li>
<li>deleteAll(Iterable<? extends T> entities) : Deletes the given entities.</li>
<li>deleteById(ID id) : Deletes the entity with the given id.</li>
<li>existsById(ID id) : Returns whether an entity with the given id exists.</li>
<li>findAll() : Returns all instances of the type.</li>
<li>findAllById(Iterable<ID> ids) : Returns all instances of the type T with the given IDs.</li>
<li>findById(ID id) : Retrieves an entity by its id.</li>
<li>save(S entity) : Saves a given entity.</li>
<li>saveAll(Iterable entities) : Saves all given entities.</li>
</ul>

</br>
For now our Architecture is : REST Controller <-> Student Service <-> Student DAO <-> Database (mySQL)
</br>

Spring Data Rest in the other hand, provide all Spring Data Jpa features and add the endpoints, minimizing the boiler-plate REST code and no additional coding is required ! 
</br>
<table>
<tr>
    <th>HTTP Method</th>
    <th>Endpoint</th>
    <th>CRUD Action</th>
</tr>

<tr>
    <th>POST</th>
    <th>/students</th>
    <th>Create a new student</th>
</tr>

<tr>
    <th>GET</th>
    <th>/students</th>
    <th>Read a list of Students</th>
</tr>

<tr>
    <th>Get</th>
    <th>/students/{studentId}</th>
    <th>Read a single student</th>
</tr>

<tr>
    <th>PUT</th>
    <th>/students/{studentId}</th>
    <th>Update an existing student</th>
</tr>

<tr>
    <th>DELETE</th>
    <th>/students/{studentId}</th>
    <th>Delete an existing student</th>
</tr>

</table>




