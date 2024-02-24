<template>
  <div @click-picture="setXY">
  <div>
    <label for="x">X:</label>
    <input type="text" id="x" class="input" v-model="x">
    <p class="errorMessage">{{ xError }}</p>
  </div>
  <div>
    <label for="x">Y:</label>
    <input type="text" id="y" class="input" v-model="y">
    <p class="errorMessage">{{ yError }}</p>
  </div>
  <div>
    <label>R:</label>
    <div>
      <input type="button"
             v-for="r in rValues"
             v-bind:class="r.class"
             v-bind:value="r.value"
             v-on:click="press(r)"
      >
    </div>
    <p class="errorMessage">{{ rError }}</p>
  </div>
  <div style="clear: both">
    <input type="submit" value="Отправить" class="small-button" v-on:click="submit()">
  </div>
  </div>
</template>

<script>
export default {
  name: 'Form',
  data: function () {
    return {
      x: undefined,
      y: undefined,
      r: undefined,
      xError: undefined,
      yError: undefined,
      rError: undefined,
      rValues: [],
    }
  },
  methods: {
    press(r) {
      this.r = r.value;
      for (let other of this.rValues) {
        other['class'] = 'small-button';
      }
      r['class'] = 'small-button-pressed';
      this.$root.changeR(this.r);
    },
    submit() {
      if (this.validateX() & this.validateY() & this.validateR()) {
        this.$root.postPoint(this.x, this.y, this.r);
      }
    },
    validateX() {
      this.xError = undefined;
      let x = parseFloat(this.x);
      if (x && x >= -5 && x <= 3)
        return true;
      this.xError = 'Введите число от -5 до 3';
    },
    validateY() {
      this.yError = undefined;
      let y = parseFloat(this.y);
      if (y && y >= -4 && y <= 4)
        return true;
      this.yError = 'Введите число от -4 до 4';
    },
    validateR() {
      this.rError = undefined;
      if (this.r)
        return true;
      this.rError = 'Выберите радиус';
    },
    setXY(x, y) {
      this.x = x;
      this.y = y;
      this.submit();
    }
  },
  mounted() {
    for (let i = -4; i <= 4; i++) {
      this.rValues.push({value: i, class: 'small-button'});
    }
  }
}
</script>

<style scoped>
.input {
  display: block;
  width: 200px;

}

.small-button {
  width: auto;
  min-width: 30px;
  height: 20px;

  display: block;
  float: left;
  margin: 7px;

  background-color: white;
  border: black solid 1px;
  border-radius: 10px;
  box-shadow: black 2px 2px 5px;
}

.small-button:hover {
  background-color: #3399ff;
  box-shadow: black 1px 1px 3px;
}

.small-button-pressed {
  width: auto;
  min-width: 30px;
  height: 20px;

  display: block;
  float: left;
  margin: 7px;

  border: black solid 1px;
  border-radius: 10px;

  background-color: #3399ff;
}

.errorMessage {
  color: red;
}
</style>
