
/*



        public void InsertarCallableCliente(){
       try{
            final String sql= "{call insertarClientes(?,?,?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            //Envia valores
            //cs.setInt(1,empleadosId);
            cs.setString(1,nombreC);
            cs.setString(2,apellidosC);
            cs.setString(3,direccionC);
            cs.setString(4,telefonoC);
            cs.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
    
        public void eliminarClientesCalleble(){
        try{
            final String sql= "{call eliminarClientes(?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Crea conexiones
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setInt(1, clientesId);//Envio de parametros, (indice, valor a enviar)
            cs.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
 
        public void buscarClientesCallable(){//Método de busca mediante procedimientos almacenados
        try{
            final String sql= "{call buscarClientesId(?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Creo conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setInt(1, clientesId);//Envio de parametros, (indice, valor a enviar)
            ResultSet registro= cs.executeQuery();//Almacena el resultado de la comsulta
            while(registro.next()){
                clientesId=registro.getInt(1);
                nombreC=registro.getString(2);
                apellidosC=registro.getString(3);
                direccionC=registro.getString(4);
                telefonoC=registro.getString(5);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
          
        public void buscarClientesApellidoCallable(){//Método de busca mediante procedimientos almacenados
        try{
            final String sql= "{call buscarClientesApellidos(?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Creo conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.setString(1, nombreC);//Envio de parametros, (indice, valor a enviar)
            cs.setString(2, apellidosC);
            ResultSet registro= cs.executeQuery();//Almacena el resultado de la comsulta
            while(registro.next()){
                clientesId=registro.getInt(1);
                nombreC=registro.getString(2);
                apellidosC=registro.getString(3);
                direccionC=registro.getString(4);
                telefonoC=registro.getString(5);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
          
        public String buscarClientesNombre(){//Método de busca mediante procedimientos almacenados
        String cadena="";//Para Almacenar valores, para que a la hora de imprimir, muestre todos
        try{
            final String sql= "{call buscarClientesNombre(?)}";//Sintaxis
            Conexion objConexion=new Conexion();//crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
           
             cs.setString(1, nombreC);
              cs.executeUpdate();
            ResultSet registro= cs.executeQuery();//Almacena resutado de la consulta
            while(registro.next()){
                //Almacena los datos
                 cadena=cadena+"ID: "+registro.getInt(1)+
                        "     Nombre: "+registro.getString(2)+
                        "     Apellidos: "+
                        registro.getString(3)+
                        "     Direccion: "+
                        registro.getString(4)+"\n\n";
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        return cadena;
    }
          
        public void modificarClientesCallable(){
        try{
            final String sql= "{call modificarC(?,?,?,?,?)}";//Sintaxis
            Conexion objConexion=new Conexion();//Crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            //Envia valores
            cs.setInt(1, clientesId);
            cs.setString(2, nombreC);
            cs.setString(3, apellidosC);
            cs.setString(4, direccionC);
            cs.setString(5, telefonoC);
            cs.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }  
    } 
     
        
        public String buscarClientesInsertado(){//Método de busca mediante procedimientos almacenados
        String cadena="";//Para Almacenar valores, para que a la hora de imprimir, muestre todos
        try{
            final String sql= "{call MCI()}";//Sintaxis
            Conexion objConexion=new Conexion();//crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.executeUpdate();
            ResultSet registro= cs.executeQuery();//Almacena resutado de la consulta
            while(registro.next()){
                //Almacena los datos
                 cadena=cadena+"ID: "+registro.getInt(2)+
                        "     Nombre: "+registro.getString(3)+
                        "     Apellidos: "+
                        registro.getString(4)+
                        "     Direccion: "+
                        registro.getString(5)+
                         "    Telefono: "+registro.getString(6)+
                         "\n\n";
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        return cadena;
    }
        
          public String buscarClientesEliminados(){//Método de busca mediante procedimientos almacenados
        String cadena="";//Para Almacenar valores, para que a la hora de imprimir, muestre todos
        try{
            final String sql= "{call MCE()}";//Sintaxis
            Conexion objConexion=new Conexion();//crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.executeUpdate();
            ResultSet registro= cs.executeQuery();//Almacena resutado de la consulta
            while(registro.next()){
                //Almacena los datos
                 cadena=cadena+"ID: "+registro.getInt(2)+
                        "     Nombre: "+registro.getString(3)+
                        "     Apellidos: "+
                        registro.getString(4)+
                        "     Direccion: "+
                        registro.getString(5)+
                         "    Telefono: "+registro.getString(6)+
                         "\n\n";
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        return cadena;
    }
        
          
            public String buscarClientesModificados(){//Método de busca mediante procedimientos almacenados
        String cadena="";//Para Almacenar valores, para que a la hora de imprimir, muestre todos
        try{
            final String sql= "{call MCA()}";//Sintaxis
            Conexion objConexion=new Conexion();//crea conexion
            CallableStatement cs= objConexion.getCon().prepareCall(sql);//Accede al procedimiento
            cs.executeUpdate();
            ResultSet registro= cs.executeQuery();//Almacena resutado de la consulta
            while(registro.next()){
                //Almacena los datos
                 cadena=cadena+"ID: "+registro.getInt(2)+
                        "     Nombre: "+registro.getString(3)+
                        "     Apellidos: "+
                        registro.getString(4)+
                        "     Direccion: "+
                        registro.getString(5)+
                         "    Telefono: "+registro.getString(6)+
                         "\n\n";
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        return cadena;
    }
            





insertar

 try{
            //Asignos valores
            //int empleadosId=Integer.parseInt(jtfId.getText());
            String nombreE=jtfNombre.getText();
            String apellidosE=jtfApellidos.getText();
            String direccionE =jtfDireccion.getText();
            String telefonoE =jtfTelefono.getText();
            //Envio parametros al contrucctor
            RegistrosClientes obj= new RegistrosClientes(nombreE, apellidosE, direccionE,telefonoE);
           // obj.setEmpleadosId(empleadosId);
            obj.setNombreC(nombreE);
            obj.setApellidosC(apellidosE);
            obj.setDireccionC(direccionE);
            obj.setTelefonoC(telefonoE);
            obj.InsertarCallableCliente();
            //jtfId.setText(null);
            jtfNombre.setText(null);
            jtfApellidos.setText(null);
            jtfDireccion.setText(null);
            jtfTelefono.setText(null);

        }catch(Exception e){
            e.printStackTrace();
        }


modificar

 try{
            //Asigno valores
            int id=Integer.parseInt(jtfId.getText());
            String nombre=jtfNombre.getText();
            String apellidos=jtfApellidos.getText();
            String direccion =jtfDireccion.getText();
            String telefono =jtfTelefono.getText();
            //ENVIO DATOS AL CONSTRUCCTOR
            RegistrosClientes obj= new RegistrosClientes(nombre, apellidos, direccion,telefono);
            obj.setClientesId(id);
            obj.setNombreC(nombre);
            obj.setApellidosC(apellidos);
            obj.setDireccionC(direccion);
            obj.setTelefonoC(telefono);
            obj.modificarClientesCallable();
           // jtfId.setText(null);
           jtfId.setText(null);
            jtfNombre.setText(null);
            jtfApellidos.setText(null);
            jtfDireccion.setText(null);
            jtfTelefono.setText(null);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }


consultar


   try{
            RegistrosClientes obj= new RegistrosClientes();//Objeto de la clase Persona
            //int id=Integer.parseInt(jtfId.getText());//Convierto a entero el valor
            String nombre=jtfNombre.getText();
            String apellidos=jtfApellidos.getText();
            obj.setNombreC(nombre);//Envio valor
            obj.setApellidosC(apellidos);
            obj.buscarClientesApellidoCallable();//Llamó al método
            jtfId.setText(String.valueOf(obj.getClientesId()));
            jtfNombre.setText(obj.getNombreC());
            jtfApellidos.setText(obj.getApellidosC());
            jtfDireccion.setText(obj.getDireccionC());
            jtfTelefono.setText(obj.getTelefonoC());
        }catch(Exception e){
            e.printStackTrace();
        }


eliminar


  try{
            RegistrosClientes obj= new RegistrosClientes();
            int id=Integer.parseInt(jtfId.getText());
            obj.setClientesId(id);
            obj.eliminarClientesCalleble();
            jtfNombre.setText(null);
            jtfApellidos.setText(null);
            jtfDireccion.setText(null);
            jtfTelefono.setText(null);
        }catch(Exception e){
            e.printStackTrace();
        }   

*/