# M06-UF4-A02-MVC

### Per què al servei estem utilitzant mètodes que no hem declarat explícitament al repositori? Com és possible?
Perque fem el extends de CrudRepository que ens proporciona els metodes.

### El repositori pot elegir fer l’extends de les interfícies PagingAndSortingRepository o de JpaRepository. En què es diferencien aquestes dues amb la interfície CrudRepository?
CrudRepository te operacions de CRUD basiques y les altres 2 apart de les bàsiques ofereixen més funcionalitats com paginació i ordenació.

### Què significa Optional<Classe> i per a què serveix?
Es un contenidor que pot o no contenir un valor. Es fa servir per evitar el NullPointerException.

### Per què el controlador utilitza el servei i no la seva implementació?
Per separar la llogica de negoci del servei, mentenint el controlador enfocat en gestionar les solicituds HTTP.

### Per què al controlador injectem la interfície del servei i no la seva implementació?
Per afavorir la inversió de dependecies i per permetre la injeccio de diferents implementacions sense modificar el codi del controlador.
