<template>
  <div class="wrapper">
    <h1>Nombre tema</h1>
    <br />
    <br />
    <div class="video-container">
      <iframe
        class="video"
        width="720"
        height="400"
        src="https://www.youtube.com/embed/MJpCcvTVlTY"
        frameborder="0"
        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen
      ></iframe>
    </div>
    <h1>Ver ejercicios</h1>
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
  margin: 10px 0px 10px 0px;
}

.video-container {
  width: 100%;
}
.video {
  margin: 0 auto;
}
</style>