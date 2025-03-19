# Documentation des End-points API Springboot

Cette documentation décrit les différents end-points utilisés pour gérer les catégories et les produits via des requête HTTP.

---

## Ajouter un produit et une catégorie.

### Méthode HTTP : `POST`
- **URL** : `http://localhost:9000/api/categorie/save`

### Description :
Ajouter une nouvelle catégorie.

### Body (JSON valide)
```Json
{
    "libele": "categorie exemple"
}
````
### Body (JSON non valide)
```Json
{
  "libele": ""
}
````

### Description :
Ajoute un produit.

### Body (JSON valide)
```Json
{
  "nom":"fourchette",
  "prix": 12.90,
  "categorie":{
    "id":1
  }
}
````
### Body (JSON non valide)
```Json
{
  "nom":"",
  "prix": 12.90,
  "categorie":{
    "id":1
  }
}
```

---

## Afficher tous les produits
### Méthode HTTP : `GET`
- **URL** : `http://localhost:9000/api/produit`

### Description :
Afficher tous les produits.

### Body (JSON - retour de postman)
```Json
[
    {
        "id": 1,
        "nom": "fourchette",
        "prix": 12.9,
        "categorie": {
            "id": 1,
            "libele": "categorie exemple"
        }
    }
]
```

---

## Afficher tous les produits
### Méthode HTTP : `GET`
- **URL** : `http://localhost:9000/api/categorie`

### Description :
Afficher toutes les catégories.

### Body (JSON - retour de postman)
```Json
[
  {
    "id": 1,
    "libele": "categorie exemple"
  }
]
```