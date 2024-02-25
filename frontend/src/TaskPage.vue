<template>
  <div id="background">
    <div class="mid">
      <div class="container">
        <input type="submit" value="Выйти" v-on:click="logout">
      </div>
      <div class="container-big">
        <div class="container-small">
          <div class="container">
            <p>Определить, попадает ли точка в заданную область:</p>
            <Picture v-bind:points="points" v-bind:r="radius"/>
          </div>
        </div>
        <div class="container-small">
          <div class="container">
            <Form ref="form"/>
          </div>
        </div>
      </div>
      <div class="container">
        <Table v-bind:points="points"/>
      </div>
    </div>
  </div>
</template>

<script>
import Form from './components/forms/PointForm.vue'
import Table from './components/Table.vue'
import Picture from './components/picture/Picture.vue'

export default {
  name: 'App',
  components: {
    Form, Table, Picture
  },
  data() {
    return {
      points: [],
      radius: 0
    }
  },
  methods: {
    logout(){
      fetch('/logout').then(response => {
            if (response.redirected) {
              window.location.replace(response.url);
            }
          }
      );
    },
    getPoints() {
      fetch('/task/points')
          .then(response => response.json())
          .then(result => this.points = result);
    },
    postPoint(x, y, r) {
      let json = JSON.stringify({
        x: x,
        y: y,
        r: r
      });
      fetch('/task/points', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: json
      }).then(() => {
        this.getPoints();
      })

    },
    changeR(r) {
      this.radius = r;
    },
    changeXY(x, y){
      this.$refs.form.setXY(x, y);
    }
  }
}
</script>

<style>
body {
  background-color: #5F87CF;
  min-width: 700px;
}

@media screen and (max-width: 1020px) {
  .mid {
    width: 700px;
    margin: 10px auto;
  }
}

@media screen and (min-width: 1020px) {
  .mid {
    margin: 10px 15%;
  }
}

.container {
  background-color: white;
  border-radius: 5px;
  box-shadow: #1F3F77 5px 5px 5px;
  padding: 5px;
  margin: 10px;
  height: 100%;
}

.container-big {
  display: flex;
  min-width: 700px;
  margin-bottom: 40px;
}

.container-small {
  width: 50%;
}
</style>
