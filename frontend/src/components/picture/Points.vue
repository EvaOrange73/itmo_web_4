<template>
  <svg>
    <circle v-for="point in computed_points"
            r="2"
            :fill="point.color"
            :cx="point.x"
            :cy="point.y"
    />
  </svg>
</template>

<script>
export default {
  name: 'Points',
  props: ['points', 'r'],
  computed: {
    computed_points() {
      let computed = [];
      for (let point of this.points) {
        if(point.r === this.r) {
          computed.push({
            x: point.x * 30,
            y: point.y * 30,
            color: point.result ? 'green' : 'red'
          })
        }
      }
      return computed;
    }
  }
}
</script>
