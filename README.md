AUTHOR: BEMTORRES

Es un programa en java que refleja los modelos de una base de datos de **Oracle || MYSQL** a clases en **Java**


## Pasos

- En **src/services/database** genera tu conexión a la base de datos
- Luego en **src/services/Main.java** configura tu conexión

```java
    // crea modelos
    boolean createModels = true;

    // crea queries
    boolean createQueries = true;

    // crea crudsql
    boolean createCrudsSQL = true;

    // seleciona tu base de datos
    String[] databaseEngine = new String[2];
    databaseEngine[0] = "mysql";
    databaseEngine[1] = "oracle";
```
- RUN al proyecto
- Se crearan carpetas automaticamente del proyecto, reflejando el modelo de la base de datos

## Datos generados   



### Pasos realizados

#### MYSQL

Cuando iniciamos sesión con MYSQL podemos ocupar el comando 
```SQL
SHOW TABLES;
```
Este comando nos respondera los nombres de todas las tablas de la base de datos.

Tambien podemos usar, para obtener todos los datos de una tabla
```SQL
DESCRIBE x_NOMBRE_TABLA_x;
```


#### ORACLE

Cuando iniciamos sesión con ORACLE podemos ocupar el comando 
```SQL
SELECT table_name FROM USER_TABLES;
``` 
Este comando nos respondera los nombres de todas las tablas de la base de datos.

Tambien podemos usar, para obtener todos los datos de una tabla
```sql
SELECT * FROM user_tab_columns WHERE table_name=x_NOMBRE_TABLA_x;
```

Columnas
1. TABLE_NAME
2. TABLESPACE_NAME
3. CLUSTER_NAME
4. IOT_NAME
5. STATUS
6. PCT_FREE
7. PCT_USED
8. INI_TRANS
9. MAX_TRANS
10. INITIAL_EXTENT
11. NEXT_EXTENT
12. MIN_EXTENTS
13. MAX_EXTENTS
14. PCT_INCREASE
15. FREELISTS
16. FREELIST_GROUPS
17. LOGGING
18. BACKED_UP
19. NUM_ROWS
20. BLOCKS
21. EMPTY_BLOCKS
22. AVG_SPACE
23. CHAIN_CNT
24. AVG_ROW_LEN
25. AVG_SPACE_FREELIST_BLOCKS
26. NUM_FREELIST_BLOCKS
27. DEGREE
28. INSTANCES
29. CACHE
30. TABLE_LOCK
31. SAMPLE_SIZE
32. LAST_ANALYZED
33. PARTITIONED
34. IOT_TYPE
35. TEMPORARY
36. SECONDARY
37. NESTED
38. BUFFER_POOL
39. FLASH_CACHE
40. CELL_FLASH_CACHE
41. ROW_MOVEMENT
42. GLOBAL_STATS
43. USER_STATS
44. DURATION
45. SKIP_CORRUPT
46. MONITORING
47. CLUSTER_OWNER
48. DEPENDENCIES
49. COMPRESSION
50. COMPRESS_FOR
51. DROPPED
52. READ_ONLY
53. SEGMENT_CREATED
54. RESULT_CACHE


#### OTRO PROYECTO CON EL MISMO PRINCIPIO EN PHP
https://github.com/bemtorres/PDO-Reflect