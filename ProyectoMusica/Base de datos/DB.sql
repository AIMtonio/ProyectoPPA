PGDMP     ;    .                w           MusicalLife    11.5    11.5     	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16397    MusicalLife    DATABASE     �   CREATE DATABASE "MusicalLife" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE "MusicalLife";
             postgres    false                       0    0    DATABASE "MusicalLife"    COMMENT     k   COMMENT ON DATABASE "MusicalLife" IS 'Base de datos para el proyecto de Programación para aplicaciones.';
                  postgres    false    2828            �            1259    16411    album    TABLE     )  CREATE TABLE public.album (
    id_album integer NOT NULL,
    nombre character varying(30),
    tipo character varying(30),
    artista integer,
    disquera integer,
    genero character varying(30),
    duracion double precision,
    fecha_lanzamiento date,
    imagen character varying(50)
);
    DROP TABLE public.album;
       public         postgres    false            �            1259    16406    artista    TABLE     �   CREATE TABLE public.artista (
    id_artista integer NOT NULL,
    nombre character varying(30),
    apellido character varying(30),
    nombre_artistico character varying(30),
    fecha_nacimiento date,
    nacionalidad character varying(30)
);
    DROP TABLE public.artista;
       public         postgres    false            �            1259    16401    disquera    TABLE     
  CREATE TABLE public.disquera (
    id_disquera integer NOT NULL,
    nombre character varying(30),
    direccion character varying(30),
    clave character varying(30),
    telefono character varying(30),
    correo character varying(30),
    fecha_creacion date
);
    DROP TABLE public.disquera;
       public         postgres    false                      0    16411    album 
   TABLE DATA               w   COPY public.album (id_album, nombre, tipo, artista, disquera, genero, duracion, fecha_lanzamiento, imagen) FROM stdin;
    public       postgres    false    198   w                 0    16406    artista 
   TABLE DATA               q   COPY public.artista (id_artista, nombre, apellido, nombre_artistico, fecha_nacimiento, nacionalidad) FROM stdin;
    public       postgres    false    197   �                 0    16401    disquera 
   TABLE DATA               k   COPY public.disquera (id_disquera, nombre, direccion, clave, telefono, correo, fecha_creacion) FROM stdin;
    public       postgres    false    196          �
           2606    16415    album album_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_pkey PRIMARY KEY (id_album);
 :   ALTER TABLE ONLY public.album DROP CONSTRAINT album_pkey;
       public         postgres    false    198            �
           2606    16410    artista artista_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.artista
    ADD CONSTRAINT artista_pkey PRIMARY KEY (id_artista);
 >   ALTER TABLE ONLY public.artista DROP CONSTRAINT artista_pkey;
       public         postgres    false    197            �
           2606    16405    disquera disquera_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.disquera
    ADD CONSTRAINT disquera_pkey PRIMARY KEY (id_disquera);
 @   ALTER TABLE ONLY public.disquera DROP CONSTRAINT disquera_pkey;
       public         postgres    false    196            �
           2606    16416    album album_artista_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_artista_fkey FOREIGN KEY (artista) REFERENCES public.artista(id_artista);
 B   ALTER TABLE ONLY public.album DROP CONSTRAINT album_artista_fkey;
       public       postgres    false    198    197    2694            �
           2606    16421    album album_disquera_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.album
    ADD CONSTRAINT album_disquera_fkey FOREIGN KEY (disquera) REFERENCES public.disquera(id_disquera);
 C   ALTER TABLE ONLY public.album DROP CONSTRAINT album_disquera_fkey;
       public       postgres    false    196    2692    198               ;   x�3����II�,)J,�4B0��T��� 	rZ�X�pf�&���q��qqq ��         ?   x�3�,�OJ-*��L�ϫJ�I-���/).H��,��4����50�54��M��LN������� e         J   x�3�,)J,HN,�K�I-�LO�Q�J��,N��42�4��4554072743�L�/*J�X����r��qqq �      