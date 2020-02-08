
Protótipo para demonstrar como fazer a intermediação entre a comunicação entre uma aplicação web e um dispositivo SAT. 

# Aplicação WEB

A aplicação web foi desenvolvida utilizando Vue.JS. 

``` bash
# instalar dependencias
npm install

# rodar a aplicação para desenvolvimento (localhost:8080)
npm run serve

# build para produção
npm run build
```

# Webserver

O webserver local foi desenvolvido em JAVA.

``` bash
# rodar a aplicação para desenvolvimento (localhost:8999)
gradlew run

# build para produção
gradlew shadowJar
```

# Emulador SAT

É necessário instalar e rodar o emulador do SAT disponibilizado pela Receita Federal
https://portal.fazenda.sp.gov.br/servicos/sat/Downloads/emulador_off_line_v2_9_4.zip

**Obs: o emulador disponibiliza apenas a DLL para 32 bits, portanto deve estar instalador o JAVA para 32 bits.**