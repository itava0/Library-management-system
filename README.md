
# Library Management System

Rest API using Sprint boot and Postgresql


## API Reference

#### Get all items

```http
  GET /api/v1/book
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/book/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |




## Authors

- [@itava0](https://www.github.com/itava0)

