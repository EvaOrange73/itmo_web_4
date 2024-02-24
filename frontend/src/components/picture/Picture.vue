<template>
  <svg width="300" height="300">
    <rect fill="white" width="300" height="300"/>
    <Figure v-bind:radius="$props.r"/>
    <Axes/>
    <Points :points="points" :r="r"/>
  </svg>
</template>

<script>
import Axes from "@/components/picture/Axes.vue";
import Figure from "@/components/picture/Figure.vue";
import Points from "@/components/picture/Points.vue";

export default {
  name: 'Picture',
  props: ['points', 'r'],
  components: { Axes, Figure, Points }
}

</script>

<style scoped>

</style>