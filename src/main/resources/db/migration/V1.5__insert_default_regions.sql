INSERT INTO public.regions(id, name)
VALUES ('c4a3850d-8219-44de-9ca5-16b79c16835d', 'Toshkent');

INSERT INTO public.places(id, name, region_id)
VALUES (gen_random_uuid(), 'Mirobod', 'c4a3850d-8219-44de-9ca5-16b79c16835d');
INSERT INTO public.places(id, name, region_id)
VALUES (gen_random_uuid(), 'Shayxontoxur', 'c4a3850d-8219-44de-9ca5-16b79c16835d');
INSERT INTO public.places(id, name, region_id)
VALUES (gen_random_uuid(), 'Yunusobod', 'c4a3850d-8219-44de-9ca5-16b79c16835d');
INSERT INTO public.places(id, name, region_id)
VALUES (gen_random_uuid(), 'Sergeli', 'c4a3850d-8219-44de-9ca5-16b79c16835d');
INSERT INTO public.places(id, name, region_id)
VALUES (gen_random_uuid(), 'Yakkasaroy', 'c4a3850d-8219-44de-9ca5-16b79c16835d');