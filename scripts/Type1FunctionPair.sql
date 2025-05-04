-- Type 1 unique functions pairs. 966 rows. We used this one.
SELECT DISTINCT ON (fc.function_one, abc.text) fc.function_id_one, fc.function_one, fc.function_id_two, abc.text AS function_two, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token
	FROM 
(SELECT c.function_id_one, f.text AS function_one, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token
	FROM public.clones AS c INNER JOIN public.pretty_printed_functions AS f
	ON c.function_id_one = f.function_id
	WHERE c.syntactic_type = 1) AS fc INNER JOIN public.pretty_printed_functions AS abc
	ON fc.function_id_two = abc.function_id
	ORDER BY fc.function_one, abc.text;

-- Type 1 functions pairs. 48116 rows. No distinction
SELECT fc.function_id_one, fc.function_one, fc.function_id_two, abc.text AS function_two, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token
	FROM 
(SELECT c.function_id_one, f.text AS function_one, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token
	FROM public.clones AS c INNER JOIN public.pretty_printed_functions AS f
	ON c.function_id_one = f.function_id
	WHERE c.syntactic_type = 1) AS fc INNER JOIN public.pretty_printed_functions AS abc
	ON fc.function_id_two = abc.function_id LIMIT 4200;





-- the below are only for tests! Not for actual usage!


-- unchecked rows
SELECT * FROM public.clones WHERE public.clones.syntactic_type = 1 LIMIT 1000;
	
-- unchecked rows
SELECT DISTINCT ON (fp.function_id_one) fp.function_id_one, ppf.text AS function_one, fp.function_id_two, fp.functionality_id, fp.syntactic_type, fp.similarity_line, fp.similarity_token
FROM public.clones AS fp INNER JOIN public.pretty_printed_functions AS ppf
ON fp.function_id_one = ppf.function_id WHERE fp.syntactic_type = 1;

-- unchecked rows
SELECT DISTINCT ON (ppf.text) fp.function_id_one, ppf.text AS function_one, fp.function_id_two, fp.functionality_id, fp.syntactic_type, fp.similarity_line, fp.similarity_token
FROM public.clones AS fp INNER JOIN public.pretty_printed_functions AS ppf
ON fp.function_id_one = ppf.function_id WHERE fp.syntactic_type = 1;

-- unchecked rows without limit
SELECT fc.function_id_one, fc.function_one, fc.function_id_two, abc.text AS function_two, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token
	FROM 
(SELECT c.function_id_one, f.text AS function_one, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token
	FROM public.clones AS c INNER JOIN public.pretty_printed_functions AS f
	ON c.function_id_one = f.function_id
	WHERE c.syntactic_type = 1) AS fc INNER JOIN public.pretty_printed_functions AS abc
	ON fc.function_id_two = abc.function_id
	ORDER BY fc.function_one LIMIT 1000;
	
-- unchecked. Add these results with unique function_one 411 pairs
SELECT fc.function_id_one, fc.function_one, fc.function_id_two, abc.text AS function_two, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token
	FROM 
(SELECT c.function_id_one, f.text AS function_one, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token
	FROM public.clones AS c INNER JOIN public.pretty_printed_functions AS f
	ON c.function_id_one = f.function_id
	WHERE c.syntactic_type = 1) AS fc INNER JOIN public.pretty_printed_functions AS abc
	ON fc.function_id_two = abc.function_id LIMIT 590;

