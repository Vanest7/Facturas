
#/bin/bash

# Generar el css y ofuscarlo
sass ./src/main/resources/static/scss/main.scss ./src/main/resources/static/css/main.css

cp ./src -r ./target/classes/static/

sass --style=compressed ./target/classes/static/src/main/resources/static/scss/main.scss ./target/classes/static/src/main/resources/static/css/main.css

# Borrar el scss
rm ./target/classes/static/src/main/resources/static/scss/main.scss