<template>
  <svg ref="pic" width="300" height="300" v-on:click="click">
    <rect fill="white" width="300" height="300"/>
    <Figure v-bind:radius="$props.r"/>
    <Axes/>
    <Points :points="points" :r="r"/>
  </svg>
  <div @click-picture="k"></div>
</template>

<script>
import Axes from "@/components/picture/Axes.vue";
import Figure from "@/components/picture/Figure.vue";
import Points from "@/components/picture/Points.vue";

export default {
  name: 'Picture',
  props: ['points', 'r'],
  components: {Axes, Figure, Points},
  emits: ['click-picture'],
  methods: {
    click: function (event) {
      let rect = this.$refs['pic'].getBoundingClientRect();
      let x = ((event.clientX - rect.x - 150) / 30).toFixed(2);
      let y = ((150 - event.clientY + rect.y) / 30).toFixed(2);
      this.$root.changeXY(x, y);
    }
  }
}

</script>

<style scoped>

</style>