# MedevSuperviseur

Lors de ce projet, vous aurez à créer une solution permettant de guider des robots dans un hôpital, afin d’acheminer des traitements anti-COVID, depuis la pharmacie dans les chambres de patients :

● sans contact humain (sécurité sanitaire)

● avec rapidité (efficacité de la distribution logistique)

● avec traçabilité (tous les mouvements seront enregistrés, afin de suivre la traçabilité par horodatage des médicaments délivrés au patient)

L’objectif est de réaliser un test en aveugle (essais cliniques), pour prouver l'efficacité (ou l’inefficacité) de 6 nouveaux médicaments (stockés dans la pharmacie) sur les patients (un par chambre). Un patient, malade du COVID, fait un séjour d’une semaine pendant laquelle le même médicament lui sera administré, 3 fois par jour.

Le superviseur central déterminera de quel médicament sera attribué par patient, et donnera les ordres aux différents robots pour acheminer les traitements de la pharmacie à la chambre appropriée. Au bout d’une semaine de traitement, le patient peut être :

● guéri : il est libéré,

● dans un état stationnaire : il est redirigé vers un autre hôpital,

● malheureusement mort (le superviseur décidera aléatoirement du statut du patient à l’issue de chaque semaine). Au bout d’un mois d’essais, des statistiques pourront être calculées afin de démontrer les résultats des différents médicaments.

Superviseur (Java)
Le rôle du superviseur est le suivi des essais cliniques :

● Par semaine, pouvoir saisir quel médicament sera fourni à quel patient (un patient par chambre) et pouvoir saisir le statut de chaque patient à l’issue des traitements (décédé, stationnaire, guéri)

● 3 fois par jour, en déduire les consignes de délivrance pour les robots (le bon médicament dans la bonne chambre)

● Fournir les statistiques complètes des mouvements et livraisons des robots (avec horodatage)

● Fournir les statistiques de l’efficacité des médicaments (% de guérison, de status quo, de décès) par semaine et par médicament 

Ce programme dialoguera avec le service Web (données formatées en JSON) pour stocker/lire les données nécessaires aux traitements indiqués, et avec les robots (fourniture des consignes, récupération de la traçabilité).
