# Pogodynka

## Funkcjonalności
* pobieranie danch ze stacji IMGW,
* prezentacja listy pomiarów,
* karta pomiarów z wybranej stacji,

## Uruchamianie
1. ``docker run --name mongo -d mongo``
1. ``mvnw install docker:build``
1. ``docker run -p 8080:8080 --name weather --link=mongo weather``

## Podgląd
![imgw_all](img/imgw_all.jpg)
![imgw_station](img/imgw_station.jpg)
![imgw_api](img/imgw_api.jpg)