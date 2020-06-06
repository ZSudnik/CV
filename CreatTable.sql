CREATE TABLE _user (
_id INTEGER PRIMARY KEY NOT NULL,
_date INTEGER KEY NOT NULL,
_name TEXT KEY NOT NULL,
_surname TEXT KEY NOT NULL,
_picture BLOB
);

CREATE TABLE _experience (
_id INTEGER PRIMARY KEY NOT NULL,
_id_cv INTEGER KEY NOT NULL,
_date_start INTEGER KEY NOT NULL,
_date_end INTEGER KEY NOT NULL,
_company TEXT KEY NOT NULL,
_position TEXT KEY NOT NULL,
_description TEXT KEY NOT NULL
);

