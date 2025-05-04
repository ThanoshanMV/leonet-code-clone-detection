-- Original query that selects all in "public.clones" table. 
SELECT function_id_one, function_id_two, functionality_id, type, syntactic_type, similarity_line, similarity_token, min_size, max_size, min_pretty_size, max_pretty_size, min_judges, min_confidence, min_tokens, max_tokens, internal
	FROM public.clones;

-- Query to uniquely select type 1 clone "functional pairs"
SELECT DISTINCT function_id_one, function_id_two, functionality_id, type, syntactic_type, similarity_line, similarity_token, min_size, min_pretty_size, min_tokens
	FROM public.clones WHERE syntactic_type = 1;

-- Original query to select functions' details
SELECT name, type, startline, endline, id, normalized_size, host, project, versioning, path, license, tokens, internal, "timestamp"
	FROM public.functions;
	
-- Query to select function's file name
SELECT name, id
	FROM public.functions;

-- Create Type 1 "file pairs" from "functional pairs"
SELECT DISTINCT fc.function_id_one, fc.file_one, fc.file_one_directory, fc.function_id_two, abc.name AS file_two, abc.type AS file_two_directory, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token, fc.min_size, fc.min_pretty_size, fc.min_tokens
	FROM 
(SELECT DISTINCT c.function_id_one, f.name AS file_one, f.type AS file_one_directory, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token, c.min_size, c.min_pretty_size, c.min_tokens
	FROM public.clones AS c INNER JOIN public.functions AS f
	ON c.function_id_one = f.id
	WHERE c.syntactic_type = 1) AS fc INNER JOIN public.functions AS abc
	ON fc.function_id_two = abc.id LIMIT 2000;
	
-- Type 1 unique file pairs only!
SELECT DISTINCT ON (fc.file_one, abc.name) fc.function_id_one, fc.file_one, fc.file_one_directory, fc.function_id_two, abc.name AS file_two, abc.type AS file_two_directory, fc.functionality_id, fc.type, fc.syntactic_type, fc.similarity_line, fc.similarity_token, fc.min_size, fc.min_pretty_size, fc.min_tokens
	FROM 
(SELECT c.function_id_one, f.name AS file_one, f.type AS file_one_directory, c.function_id_two, c.functionality_id, c.type, c.syntactic_type, c.similarity_line, c.similarity_token, c.min_size, c.min_pretty_size, c.min_tokens
	FROM public.clones AS c INNER JOIN public.functions AS f
	ON c.function_id_one = f.id
	WHERE c.syntactic_type = 1) AS fc INNER JOIN public.functions AS abc
	ON fc.function_id_two = abc.id
	ORDER BY fc.file_one, abc.name
	LIMIT 2100;
	
	