<template>
  <svg width="300" height="300">
    <rect fill="white" width="300" height="300"/>
    <Figure v-bind:radius="$props.r"/>
    <Axes/>
  </svg>
</template>

<script>
import Axes from "@/components/picture/Axes.vue";
import Figure from "@/components/picture/Figure.vue";

export default {
  name: 'Picture',
  props: ['points', 'r'],
  components: { Axes, Figure }
}

</script>

<style scoped>

</style>