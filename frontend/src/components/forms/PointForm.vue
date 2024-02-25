<template>
  <div @click-picture="setXY">
    <div>
      <input type="text" placeholder="X" id="x" class="input" v-model="x">
      <p class="errorMessage">{{ xError }}</p>
    </div>
    <div>
      <input type="text" placeholder="Y" id="y" class="input" v-model="y">
      <p class="errorMessage">{{ yError }}</p>
    </div>
    <div>
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
      <input type="submit" value="Отправить" v-on:click="submit()">
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
        other['class'] = '';
      }
      r['class'] = 'pressed';
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
      if (this.r > 0)
        return true;
      this.rError = 'Выберите положительный радиус';
    },
    setXY(x, y) {
      this.x = x;
      this.y = y;
      this.submit();
    }
  },
  mounted() {
    for (let i = -4; i <= 4; i++) {
      this.rValues.push({value: i, class: 'small-button.css'});
    }
  }
}
</script>

<style>
@import "../../../styles/form.css";
@import "../../../styles/button.css";
</style>
