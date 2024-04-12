#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "hash_tables.h"

/**
 * hash_table_create - creates a hash table
 * @size: size of the array
 *
 * Return: a pointer to the newly created hash table, or NULL if it fails
 */
hash_table_t *hash_table_create(unsigned long int size)
{
	hash_table_t *ht;

	ht = (hash_table_t *) malloc(sizeof(hash_table_t));
	if (ht == NULL)
	{
		return (NULL);
	}

	ht->size = size;
	ht->array = (hash_node_t **) malloc(size * sizeof(hash_node_t *));

	if (ht->array == NULL)
	{
		free(ht);
		return (NULL);
	}

	return (ht);
}


unsigned long int hash_djb2(const unsigned char *str)
{
	unsigned long int hash;
	int c;

	hash = 5381;
	while ((c = *str++))
	{
		hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
	}
	return (hash);
}


/**
 * key_index - gives the index of a key in a hash table
 * @key: the key string
 * @size: size of the hash table's array
 *
 * Return: the index at which the key should be stored in the hash table
 */
unsigned long int key_index(const unsigned char *key, unsigned long int size)
{
	unsigned long int index;

	index = hash_djb2(key) % size;
	return (index);
}


/**
 * insert_new_node - creates a new node and inserts it at the right index.
 * this function should be called only when the key is not already present
 * in the table
 * @ht: pointer to the hash table
 * @k: string representing the key
 * @v: the key corresponding value
 * @idx: index at which the new node should be inserted
 *
 * Return: 1 if successful, 0 otherwise
 */
int insert_new_node(hash_table_t *ht, const char *k, const char *v, int idx)
{
	hash_node_t *new_node;

	new_node = (hash_node_t *) malloc(sizeof(hash_node_t));
	if (new_node == NULL)
		return (0);

	new_node->key = strdup(k);
	if (new_node->key == NULL)
	{
		free(new_node);
		return (0);
	}
	new_node->value = strdup(v);
	if (new_node->value == NULL)
	{
		free(new_node->key);
		free(new_node);
		return (0);
	}

	new_node->next = ht->array[idx];
	ht->array[idx] = new_node;
	return (1);
}


/**
 * hash_table_set - puts a key, value pair in the hash table
 * @ht: pointer to the hash table
 * @key: string representing the key
 * @value: the key corresponding value
 *
 * Return: 1 if successful, 0 otherwise
 */
int hash_table_set(hash_table_t *ht, const char *key, const char *value)
{
	unsigned long int index;
	hash_node_t *itr;
	char *temp_val_ptr;

	if (ht == NULL || key == NULL)
		return (0);

	index = key_index((const unsigned char *)key, ht->size);
	itr = ht->array[index];

	while (itr != NULL)
	{
		if (strcmp(itr->key, key) == 0)
		{
			temp_val_ptr = strdup(value);
			if (temp_val_ptr == NULL)
				return (0);
			free(itr->value);
			itr->value = temp_val_ptr;
			return (1);
		}
		itr = itr->next;
	}

	return (insert_new_node(ht, key, value, index));
}


/**
 * hash_table_get - retrieves the key corresponding value if exists
 * @ht: pointer to the hash table
 * @key: the key string
 *
 * Return: the key corresponding value
 */
char *hash_table_get(const hash_table_t *ht, const char *key)
{
	unsigned long int index;
	hash_node_t *itr;

	if (ht == NULL || key == NULL)
		return (NULL);

	index = key_index((const unsigned char *)key, ht->size);
	itr = ht->array[index];

	while (itr != NULL)
	{
		if (strcmp(itr->key, key) == 0)
			return (itr->value);
		itr = itr->next;
	}

	return (NULL);
}



/**
 * hash_table_print - prints the pair elements in the hash table
 * @ht: pointer to the hash table
 */
void hash_table_print(const hash_table_t *ht)
{
	unsigned long int i;
	int is_first_element = 1;
	hash_node_t *itr;

	if (ht == NULL)
		return;

	printf("{");
	for (i = 0; i < ht->size; i++)
	{
		itr = ht->array[i];

		while (itr != NULL)
		{
			if (is_first_element)
			{
				printf("'%s': '%s'", itr->key, itr->value);
				is_first_element = 0;
			}
			else
			{
				printf(", ");
				printf("'%s': '%s'", itr->key, itr->value);
			}
			itr = itr->next;
		}
	}
	printf("}\n");
}


/**
 * hash_table_delete - deletes and frees memory of the given hash table
 * @ht: pointer to the hash table
 */
void hash_table_delete(hash_table_t *ht)
{
	unsigned long int i;
	hash_node_t *itr, *temp;

	if (ht == NULL)
		return;

	for (i = 0; i < ht->size; i++)
	{
		itr = ht->array[i];
		while (itr != NULL)
		{
			temp = itr->next;
			free(itr->key);
			free(itr->value);
			free(itr);
			itr = temp;
		}
	}
	free(ht->array);
	free(ht);
}

