PGDMP     4                     z         
   university    15.1    15.1 ]    m           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            n           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            o           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            p           1262    32768 
   university    DATABASE     �   CREATE DATABASE university WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Ukrainian_Ukraine.1251';
    DROP DATABASE university;
                postgres    false            �            1255    66095    delete_department_in_faculty()    FUNCTION     �   CREATE FUNCTION public.delete_department_in_faculty() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    delete from faculty_departments where faculty_departments.departments_id = old.id;
    return old;
end;
$$;
 5   DROP FUNCTION public.delete_department_in_faculty();
       public          postgres    false            �            1255    66093    delete_department_in_group()    FUNCTION     �   CREATE FUNCTION public.delete_department_in_group() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        delete from department_groups where department_groups.department_id = old.id;
        return old;
    end;
$$;
 3   DROP FUNCTION public.delete_department_in_group();
       public          postgres    false            �            1255    66235    delete_faculty_in_department()    FUNCTION     �   CREATE FUNCTION public.delete_faculty_in_department() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        delete from faculty_departments where faculty_departments.faculty_id = old.id;
        return old;
    end;
$$;
 5   DROP FUNCTION public.delete_faculty_in_department();
       public          postgres    false            �            1255    65950    delete_group_in_department()    FUNCTION     �   CREATE FUNCTION public.delete_group_in_department() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        delete from department_groups where department_groups.groups_id = old.id;
        return old;
    end;
$$;
 3   DROP FUNCTION public.delete_group_in_department();
       public          postgres    false            �            1255    65952    delete_group_in_student()    FUNCTION     �   CREATE FUNCTION public.delete_group_in_student() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    delete from un_group_students where un_group_students.un_group_id = old.id;
    return old;
end;
$$;
 0   DROP FUNCTION public.delete_group_in_student();
       public          postgres    false            �            1255    65804    delete_student_in_group()    FUNCTION     �   CREATE FUNCTION public.delete_student_in_group() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        delete from un_group_students where un_group_students.students_id = old.id;
        return old;
    end;
$$;
 0   DROP FUNCTION public.delete_student_in_group();
       public          postgres    false            �            1259    66238 
   department    TABLE     �   CREATE TABLE public.department (
    id bigint NOT NULL,
    description text NOT NULL,
    img_src text NOT NULL,
    name character varying(100) NOT NULL,
    short_name character varying(10) NOT NULL,
    faculty_id bigint
);
    DROP TABLE public.department;
       public         heap    postgres    false            �            1259    66246    department_groups    TABLE     l   CREATE TABLE public.department_groups (
    department_id bigint NOT NULL,
    groups_id bigint NOT NULL
);
 %   DROP TABLE public.department_groups;
       public         heap    postgres    false            �            1259    66237    department_id_seq    SEQUENCE     z   CREATE SEQUENCE public.department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.department_id_seq;
       public          postgres    false    215            q           0    0    department_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.department_id_seq OWNED BY public.department.id;
          public          postgres    false    214            �            1259    66250 
   discipline    TABLE     e   CREATE TABLE public.discipline (
    id bigint NOT NULL,
    name character varying(100) NOT NULL
);
    DROP TABLE public.discipline;
       public         heap    postgres    false            �            1259    66249    discipline_id_seq    SEQUENCE     z   CREATE SEQUENCE public.discipline_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.discipline_id_seq;
       public          postgres    false    218            r           0    0    discipline_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.discipline_id_seq OWNED BY public.discipline.id;
          public          postgres    false    217            �            1259    66257    faculty    TABLE     �   CREATE TABLE public.faculty (
    id bigint NOT NULL,
    description text NOT NULL,
    img_src text NOT NULL,
    name character varying(100) NOT NULL,
    short_name character varying(100) NOT NULL
);
    DROP TABLE public.faculty;
       public         heap    postgres    false            �            1259    66265    faculty_departments    TABLE     p   CREATE TABLE public.faculty_departments (
    faculty_id bigint NOT NULL,
    departments_id bigint NOT NULL
);
 '   DROP TABLE public.faculty_departments;
       public         heap    postgres    false            �            1259    66256    faculty_id_seq    SEQUENCE     w   CREATE SEQUENCE public.faculty_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.faculty_id_seq;
       public          postgres    false    220            s           0    0    faculty_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.faculty_id_seq OWNED BY public.faculty.id;
          public          postgres    false    219            �            1259    66269    news    TABLE     �   CREATE TABLE public.news (
    id bigint NOT NULL,
    date date NOT NULL,
    description text NOT NULL,
    img_src text NOT NULL,
    title character varying(255) NOT NULL
);
    DROP TABLE public.news;
       public         heap    postgres    false            �            1259    66268    news_id_seq    SEQUENCE     t   CREATE SEQUENCE public.news_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.news_id_seq;
       public          postgres    false    223            t           0    0    news_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.news_id_seq OWNED BY public.news.id;
          public          postgres    false    222            �            1259    66278    schedule    TABLE     )  CREATE TABLE public.schedule (
    id bigint NOT NULL,
    classroom character varying(32) NOT NULL,
    day character varying(32) NOT NULL,
    name character varying(32) NOT NULL,
    "time" character varying(32) NOT NULL,
    discipline_id bigint,
    group_id bigint,
    teacher_id bigint
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            �            1259    66277    schedule_id_seq    SEQUENCE     x   CREATE SEQUENCE public.schedule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.schedule_id_seq;
       public          postgres    false    225            u           0    0    schedule_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.schedule_id_seq OWNED BY public.schedule.id;
          public          postgres    false    224            �            1259    66285    student    TABLE     )  CREATE TABLE public.student (
    id bigint NOT NULL,
    email character varying(100) NOT NULL,
    name character varying(32) NOT NULL,
    patronymic character varying(32) NOT NULL,
    phone character varying(13) NOT NULL,
    surname character varying(64) NOT NULL,
    un_group_id bigint
);
    DROP TABLE public.student;
       public         heap    postgres    false            �            1259    66284    student_id_seq    SEQUENCE     w   CREATE SEQUENCE public.student_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.student_id_seq;
       public          postgres    false    227            v           0    0    student_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.student_id_seq OWNED BY public.student.id;
          public          postgres    false    226            �            1259    66292    teacher    TABLE       CREATE TABLE public.teacher (
    id bigint NOT NULL,
    email character varying(100) NOT NULL,
    name character varying(32) NOT NULL,
    patronymic character varying(32) NOT NULL,
    phone character varying(13) NOT NULL,
    surname character varying(64) NOT NULL
);
    DROP TABLE public.teacher;
       public         heap    postgres    false            �            1259    66291    teacher_id_seq    SEQUENCE     w   CREATE SEQUENCE public.teacher_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.teacher_id_seq;
       public          postgres    false    229            w           0    0    teacher_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.teacher_id_seq OWNED BY public.teacher.id;
          public          postgres    false    228            �            1259    66299    un_group    TABLE     �   CREATE TABLE public.un_group (
    id bigint NOT NULL,
    course character varying(100) NOT NULL,
    name character varying(100) NOT NULL,
    department_id bigint
);
    DROP TABLE public.un_group;
       public         heap    postgres    false            �            1259    66298    un_group_id_seq    SEQUENCE     x   CREATE SEQUENCE public.un_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.un_group_id_seq;
       public          postgres    false    231            x           0    0    un_group_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.un_group_id_seq OWNED BY public.un_group.id;
          public          postgres    false    230            �            1259    66305    un_group_students    TABLE     l   CREATE TABLE public.un_group_students (
    un_group_id bigint NOT NULL,
    students_id bigint NOT NULL
);
 %   DROP TABLE public.un_group_students;
       public         heap    postgres    false            �           2604    66241    department id    DEFAULT     n   ALTER TABLE ONLY public.department ALTER COLUMN id SET DEFAULT nextval('public.department_id_seq'::regclass);
 <   ALTER TABLE public.department ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            �           2604    66253    discipline id    DEFAULT     n   ALTER TABLE ONLY public.discipline ALTER COLUMN id SET DEFAULT nextval('public.discipline_id_seq'::regclass);
 <   ALTER TABLE public.discipline ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    66260 
   faculty id    DEFAULT     h   ALTER TABLE ONLY public.faculty ALTER COLUMN id SET DEFAULT nextval('public.faculty_id_seq'::regclass);
 9   ALTER TABLE public.faculty ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    220    220            �           2604    66272    news id    DEFAULT     b   ALTER TABLE ONLY public.news ALTER COLUMN id SET DEFAULT nextval('public.news_id_seq'::regclass);
 6   ALTER TABLE public.news ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223            �           2604    66281    schedule id    DEFAULT     j   ALTER TABLE ONLY public.schedule ALTER COLUMN id SET DEFAULT nextval('public.schedule_id_seq'::regclass);
 :   ALTER TABLE public.schedule ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    66288 
   student id    DEFAULT     h   ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.student_id_seq'::regclass);
 9   ALTER TABLE public.student ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    226    227            �           2604    66295 
   teacher id    DEFAULT     h   ALTER TABLE ONLY public.teacher ALTER COLUMN id SET DEFAULT nextval('public.teacher_id_seq'::regclass);
 9   ALTER TABLE public.teacher ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    229    228    229            �           2604    66302    un_group id    DEFAULT     j   ALTER TABLE ONLY public.un_group ALTER COLUMN id SET DEFAULT nextval('public.un_group_id_seq'::regclass);
 :   ALTER TABLE public.un_group ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    231    230    231            Y          0    66238 
   department 
   TABLE DATA           \   COPY public.department (id, description, img_src, name, short_name, faculty_id) FROM stdin;
    public          postgres    false    215   �q       Z          0    66246    department_groups 
   TABLE DATA           E   COPY public.department_groups (department_id, groups_id) FROM stdin;
    public          postgres    false    216   �s       \          0    66250 
   discipline 
   TABLE DATA           .   COPY public.discipline (id, name) FROM stdin;
    public          postgres    false    218   t       ^          0    66257    faculty 
   TABLE DATA           M   COPY public.faculty (id, description, img_src, name, short_name) FROM stdin;
    public          postgres    false    220   yt       _          0    66265    faculty_departments 
   TABLE DATA           I   COPY public.faculty_departments (faculty_id, departments_id) FROM stdin;
    public          postgres    false    221   Dw       a          0    66269    news 
   TABLE DATA           E   COPY public.news (id, date, description, img_src, title) FROM stdin;
    public          postgres    false    223   kw       c          0    66278    schedule 
   TABLE DATA           i   COPY public.schedule (id, classroom, day, name, "time", discipline_id, group_id, teacher_id) FROM stdin;
    public          postgres    false    225   0y       e          0    66285    student 
   TABLE DATA           [   COPY public.student (id, email, name, patronymic, phone, surname, un_group_id) FROM stdin;
    public          postgres    false    227   My       g          0    66292    teacher 
   TABLE DATA           N   COPY public.teacher (id, email, name, patronymic, phone, surname) FROM stdin;
    public          postgres    false    229   z       i          0    66299    un_group 
   TABLE DATA           C   COPY public.un_group (id, course, name, department_id) FROM stdin;
    public          postgres    false    231   �z       j          0    66305    un_group_students 
   TABLE DATA           E   COPY public.un_group_students (un_group_id, students_id) FROM stdin;
    public          postgres    false    232   "{       y           0    0    department_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.department_id_seq', 3, true);
          public          postgres    false    214            z           0    0    discipline_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.discipline_id_seq', 12, true);
          public          postgres    false    217            {           0    0    faculty_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.faculty_id_seq', 10, true);
          public          postgres    false    219            |           0    0    news_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.news_id_seq', 6, true);
          public          postgres    false    222            }           0    0    schedule_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.schedule_id_seq', 1, false);
          public          postgres    false    224            ~           0    0    student_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.student_id_seq', 8, true);
          public          postgres    false    226                       0    0    teacher_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.teacher_id_seq', 10, true);
          public          postgres    false    228            �           0    0    un_group_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.un_group_id_seq', 4, true);
          public          postgres    false    230            �           2606    66245    department department_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.department DROP CONSTRAINT department_pkey;
       public            postgres    false    215            �           2606    66255    discipline discipline_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.discipline
    ADD CONSTRAINT discipline_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.discipline DROP CONSTRAINT discipline_pkey;
       public            postgres    false    218            �           2606    66264    faculty faculty_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.faculty
    ADD CONSTRAINT faculty_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.faculty DROP CONSTRAINT faculty_pkey;
       public            postgres    false    220            �           2606    66276    news news_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.news
    ADD CONSTRAINT news_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.news DROP CONSTRAINT news_pkey;
       public            postgres    false    223            �           2606    66283    schedule schedule_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pkey;
       public            postgres    false    225            �           2606    66290    student student_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
       public            postgres    false    227            �           2606    66297    teacher teacher_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.teacher
    ADD CONSTRAINT teacher_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.teacher DROP CONSTRAINT teacher_pkey;
       public            postgres    false    229            �           2606    66313 .   un_group_students uk_771yg2ppfdr36k58sc35w0kvo 
   CONSTRAINT     p   ALTER TABLE ONLY public.un_group_students
    ADD CONSTRAINT uk_771yg2ppfdr36k58sc35w0kvo UNIQUE (students_id);
 X   ALTER TABLE ONLY public.un_group_students DROP CONSTRAINT uk_771yg2ppfdr36k58sc35w0kvo;
       public            postgres    false    232            �           2606    66311 0   faculty_departments uk_9r3cxgbbksb3fxtvmumngipko 
   CONSTRAINT     u   ALTER TABLE ONLY public.faculty_departments
    ADD CONSTRAINT uk_9r3cxgbbksb3fxtvmumngipko UNIQUE (departments_id);
 Z   ALTER TABLE ONLY public.faculty_departments DROP CONSTRAINT uk_9r3cxgbbksb3fxtvmumngipko;
       public            postgres    false    221            �           2606    66309 .   department_groups uk_s5yp2o1pyh0ab8fbcq0ru8q13 
   CONSTRAINT     n   ALTER TABLE ONLY public.department_groups
    ADD CONSTRAINT uk_s5yp2o1pyh0ab8fbcq0ru8q13 UNIQUE (groups_id);
 X   ALTER TABLE ONLY public.department_groups DROP CONSTRAINT uk_s5yp2o1pyh0ab8fbcq0ru8q13;
       public            postgres    false    216            �           2606    66304    un_group un_group_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.un_group
    ADD CONSTRAINT un_group_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.un_group DROP CONSTRAINT un_group_pkey;
       public            postgres    false    231            �           2620    66377 /   department before_delete_department_for_faculty    TRIGGER     �   CREATE TRIGGER before_delete_department_for_faculty BEFORE DELETE ON public.department FOR EACH ROW EXECUTE FUNCTION public.delete_department_in_faculty();
 H   DROP TRIGGER before_delete_department_for_faculty ON public.department;
       public          postgres    false    237    215            �           2620    66376 -   department before_delete_department_for_group    TRIGGER     �   CREATE TRIGGER before_delete_department_for_group BEFORE DELETE ON public.department FOR EACH ROW EXECUTE FUNCTION public.delete_department_in_group();
 F   DROP TRIGGER before_delete_department_for_group ON public.department;
       public          postgres    false    236    215            �           2620    66375 ,   faculty before_delete_faculty_for_department    TRIGGER     �   CREATE TRIGGER before_delete_faculty_for_department BEFORE DELETE ON public.faculty FOR EACH ROW EXECUTE FUNCTION public.delete_faculty_in_department();
 E   DROP TRIGGER before_delete_faculty_for_department ON public.faculty;
       public          postgres    false    238    220            �           2620    66378 +   un_group before_delete_group_for_department    TRIGGER     �   CREATE TRIGGER before_delete_group_for_department BEFORE DELETE ON public.un_group FOR EACH ROW EXECUTE FUNCTION public.delete_group_in_department();
 D   DROP TRIGGER before_delete_group_for_department ON public.un_group;
       public          postgres    false    231    234            �           2620    66379 (   un_group before_delete_group_for_student    TRIGGER     �   CREATE TRIGGER before_delete_group_for_student BEFORE DELETE ON public.un_group FOR EACH ROW EXECUTE FUNCTION public.delete_group_in_student();
 A   DROP TRIGGER before_delete_group_for_student ON public.un_group;
       public          postgres    false    235    231            �           2620    66380    student before_delete_student    TRIGGER     �   CREATE TRIGGER before_delete_student BEFORE DELETE ON public.student FOR EACH ROW EXECUTE FUNCTION public.delete_student_in_group();
 6   DROP TRIGGER before_delete_student ON public.student;
       public          postgres    false    233    227            �           2606    66329 /   faculty_departments fk4so1csx6ahvdwjbidtw8v2atb    FK CONSTRAINT     �   ALTER TABLE ONLY public.faculty_departments
    ADD CONSTRAINT fk4so1csx6ahvdwjbidtw8v2atb FOREIGN KEY (departments_id) REFERENCES public.department(id);
 Y   ALTER TABLE ONLY public.faculty_departments DROP CONSTRAINT fk4so1csx6ahvdwjbidtw8v2atb;
       public          postgres    false    3235    215    221            �           2606    66339 $   schedule fke7n46ean4msfykosu0f8sl8b8    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT fke7n46ean4msfykosu0f8sl8b8 FOREIGN KEY (discipline_id) REFERENCES public.discipline(id);
 N   ALTER TABLE ONLY public.schedule DROP CONSTRAINT fke7n46ean4msfykosu0f8sl8b8;
       public          postgres    false    225    3239    218            �           2606    66369 -   un_group_students fkgf3753yt9r23s5gpchef2r7b0    FK CONSTRAINT     �   ALTER TABLE ONLY public.un_group_students
    ADD CONSTRAINT fkgf3753yt9r23s5gpchef2r7b0 FOREIGN KEY (un_group_id) REFERENCES public.un_group(id);
 W   ALTER TABLE ONLY public.un_group_students DROP CONSTRAINT fkgf3753yt9r23s5gpchef2r7b0;
       public          postgres    false    231    232    3253            �           2606    66344 $   schedule fkijv5du1crmv70hi5sdu4a6jfr    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT fkijv5du1crmv70hi5sdu4a6jfr FOREIGN KEY (group_id) REFERENCES public.un_group(id);
 N   ALTER TABLE ONLY public.schedule DROP CONSTRAINT fkijv5du1crmv70hi5sdu4a6jfr;
       public          postgres    false    3253    231    225            �           2606    66314 &   department fkj2xhv1clx0m0axk2y53wm4hgl    FK CONSTRAINT     �   ALTER TABLE ONLY public.department
    ADD CONSTRAINT fkj2xhv1clx0m0axk2y53wm4hgl FOREIGN KEY (faculty_id) REFERENCES public.faculty(id);
 P   ALTER TABLE ONLY public.department DROP CONSTRAINT fkj2xhv1clx0m0axk2y53wm4hgl;
       public          postgres    false    220    215    3241            �           2606    66354 #   student fkl1e461nj239pqsshq7je8hprb    FK CONSTRAINT     �   ALTER TABLE ONLY public.student
    ADD CONSTRAINT fkl1e461nj239pqsshq7je8hprb FOREIGN KEY (un_group_id) REFERENCES public.un_group(id);
 M   ALTER TABLE ONLY public.student DROP CONSTRAINT fkl1e461nj239pqsshq7je8hprb;
       public          postgres    false    3253    231    227            �           2606    66324 -   department_groups fkm9jxeri5ayfo1cqgsq03yssi9    FK CONSTRAINT     �   ALTER TABLE ONLY public.department_groups
    ADD CONSTRAINT fkm9jxeri5ayfo1cqgsq03yssi9 FOREIGN KEY (department_id) REFERENCES public.department(id);
 W   ALTER TABLE ONLY public.department_groups DROP CONSTRAINT fkm9jxeri5ayfo1cqgsq03yssi9;
       public          postgres    false    216    215    3235            �           2606    66334 /   faculty_departments fkmeg9wkmi37ysc4tn7w2nycew6    FK CONSTRAINT     �   ALTER TABLE ONLY public.faculty_departments
    ADD CONSTRAINT fkmeg9wkmi37ysc4tn7w2nycew6 FOREIGN KEY (faculty_id) REFERENCES public.faculty(id);
 Y   ALTER TABLE ONLY public.faculty_departments DROP CONSTRAINT fkmeg9wkmi37ysc4tn7w2nycew6;
       public          postgres    false    3241    221    220            �           2606    66359 $   un_group fkmjcgbjskh5gvm0kw1nppaemf2    FK CONSTRAINT     �   ALTER TABLE ONLY public.un_group
    ADD CONSTRAINT fkmjcgbjskh5gvm0kw1nppaemf2 FOREIGN KEY (department_id) REFERENCES public.department(id);
 N   ALTER TABLE ONLY public.un_group DROP CONSTRAINT fkmjcgbjskh5gvm0kw1nppaemf2;
       public          postgres    false    231    3235    215            �           2606    66319 -   department_groups fkms0covst4y3f7ffonhrgwng1t    FK CONSTRAINT     �   ALTER TABLE ONLY public.department_groups
    ADD CONSTRAINT fkms0covst4y3f7ffonhrgwng1t FOREIGN KEY (groups_id) REFERENCES public.un_group(id);
 W   ALTER TABLE ONLY public.department_groups DROP CONSTRAINT fkms0covst4y3f7ffonhrgwng1t;
       public          postgres    false    231    3253    216            �           2606    66349 $   schedule fkof1t073hsxioayk2covxfe8um    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT fkof1t073hsxioayk2covxfe8um FOREIGN KEY (teacher_id) REFERENCES public.teacher(id);
 N   ALTER TABLE ONLY public.schedule DROP CONSTRAINT fkof1t073hsxioayk2covxfe8um;
       public          postgres    false    229    3251    225            �           2606    66364 -   un_group_students fktehh088vx0f36s3n1q5rr2bwd    FK CONSTRAINT     �   ALTER TABLE ONLY public.un_group_students
    ADD CONSTRAINT fktehh088vx0f36s3n1q5rr2bwd FOREIGN KEY (students_id) REFERENCES public.student(id);
 W   ALTER TABLE ONLY public.un_group_students DROP CONSTRAINT fktehh088vx0f36s3n1q5rr2bwd;
       public          postgres    false    227    3249    232            Y     x��U�n1<�_�����"@oE�(�c.�D����c��}��ͥ�90�IK9C�g��M�p��	,���P4��TW޵xH�!���@���Լ ��u,�9�l�Q�|���g=--�m�U�Fڳi�!�JL=�09A���$���K\ �ݎ���Q����c$�w
�,�r��_0[�[Lq��`a�n���X<Ԅ�	��>��̅[�s��;JM��'�+� l�ІCm� �=�7�&�L������
C��;�+x��lyK�
<:Ɍ�Q\>�hщ�
�jJk�I�+�>��[�'��
����TOS;
�AT��~�v���3`#�V��0�ǿԡ��u&<�Aa�Ă.u�w�O�����˩U4����F��$�#j>�<�NzH2E�f5ۗ2�o]glP#5��Rr��nH42�^�c��;ݡAK�}y
]~�_����VoC?{��Л�6�����F�^�����'n��Y�Yb����%���J�qs�gs���#�gG���|��YU�      Z      x�3�4�2�4bc 6����� W�      \   O   x�U�;
�0 ��9�dc~�C�������vS��F�ֿ��w�CDgdq.$g";3�Y��Js6V����� 4�)��� �<7      ^   �  x���n�@���S��v��I'$��	�	���N�)�]w���
W���^"y#�q�+s�K4��|���Vf�BF�g��KGu k
xeV@��(��OD���5e�E5yIf�)�> n����{\+����(*h����-� �3������֛h$���D]� ��HR�p��H�`$�� 'T�{q֦��Gt�%mUYe��)୳d8�*n/$��q1/Q#��h��n�� ��N�/G�n�����5�G�2��W��CC:'y�6�����ԈV���S�Ng�������=ΪvT�AӍ���=X'	t<h�B<mG}k�l��N����q��[m��
M�RM/��w�ל�GEv!�:�N�iG�D}P���Ó�����W�Ae�&�Fc; 7lm�J%4�(����Ϛ�܎E��5�t=��T����y���lC�������:���T��)��6����}����U���j�r����>J6���nlN�B�v¨��]
yW3_,���t�*n���fvb1���<q��L\����켏������\X����ݏݯ�������������EB4!��E��"����e�2q9"��e/�����\X�V}�J\&.�#r9`1�����e�2q9"���>�J\&.�#r9`1�MO�kN���D��9�f�,�� ��@�      _      x�3�4�2�4bc�=... "      a   �  x��S�n�0<K_�`I��G�[�^z	z�@�Pki��]���we1�I� ���١�W�z�^�u�m6���@� �\xI!�|,Lƣ�7��� N(+�1��W<����-|��8�
�	�"N*�NL�C�0�s�������]`�I�L(�*Kɉ4Sp�R �z�q\�QOe[�0�$�oᓣc1����L�܆���'d��⊿8��@�����m��W�c¼��b�M�Ii6%�>;�&�6�Q�4���-����l@mU)IŴ���Ȫ��`,&��R���m5�$~�:u���)�(i�Jlm�]�����m���w�=l��?�g��~�kX�}m.`����gn\�bs�yl��z��s_o�ɺ�4�8��~��g�[�M��_�@F��oX��OuWon?��c��۷,��ih[�n���؆v�����?�o��      c      x������ � �      e   �   x�u�M
�0��ur��I�g�	�� �)�j]x{��Y|<�0���cw�[���d����3�o��J��9^�,	��<��;z��� � ,? ��5�K�7
�!�B	�FAP 3�5�%��T�2@5@%@�R�3�5�%��V@�AJ@���Yk�՝�      g   �   x�uҿ
�@��y�\�_r����(��-x-h�^QN"��d��~�mS������[?��;}_vǼ���Y��}�bo12��۰�2�*VQ�T�G	�%V(\U��8��f�_�(^*���!T%(J�Jh��U����-�*�($j�pUXQX*�laHUI�����-	��fg�ݙ��f8� �P��      i   6   x�3�4THJL�H��/�t/�/-�7���2�7�c���M0�M@�1z\\\ �m      j   $   x�3�4�2�4bc 6bS 6bs ������� TYm     