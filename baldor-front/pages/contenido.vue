<template>
  <div class="wrapper">
    <h1>Temas disponibles</h1>
    <br />
    <br />
    <div class="tema">
      <nuxt-link to="videos">Reduccion de Polinomios</nuxt-link>
    </div>
    <div class="tema">
      <nuxt-link to="videos">Reducción de términos semejantes</nuxt-link>
    </div>
    <div class="tema">
      <nuxt-link to="videos">Reducción de términos semejantes con fracciones</nuxt-link>
    </div>
    <div class="tema">
      <nuxt-link to="videos">Ecuaciones de una incognita</nuxt-link>
    </div>
  </div>
</template>

<style scoped>
.wrapper {
  width: 80%;
  margin: 0 auto;
  font-family: "Inconsolata", monospace;
  padding: 3px;
}
.wrapper h1 {
  text-align: center;
  font-size: 2rem;
  color: rgb(140, 228, 181);
}

.video-container {
  width: 100%;
}
.video {
  margin: 0 auto;
}
.tema {
  border: 1px solid gainsboro;
  border-radius: 25px;
  background-color: rgb(140, 228, 181);
  width: 75%;
  margin: 0 auto;
  text-align: center;
  font-weight: bold;
  font-size: 1.5rem;
  margin-bottom: 15px;
}
.tema:hover {
  background-color: green;
}
</style>