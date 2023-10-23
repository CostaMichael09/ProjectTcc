import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const Carro = () => import('@/entities/carro/carro.vue');
// prettier-ignore
const CarroDetails = () => import('@/entities/carro/carro-details.vue');
// prettier-ignore
const CarroProcessDetails = () => import('@/entities/carro-process/carro-process-details.vue');
// prettier-ignore
const CarroProcessList = () => import('@/entities/carro-process/carro-process-list.vue');
// prettier-ignore
const CarroStartFormInit = () => import('@/entities/carro-process/carro-start-form-init.vue');
// prettier-ignore
const CarroProcess_EscolherVeiculoDetails = () => import('@/entities/carro-process/escolher-veiculo/escolher-veiculo-details.vue');
// prettier-ignore
const CarroProcess_EscolherVeiculoExecute = () => import('@/entities/carro-process/escolher-veiculo/escolher-veiculo-execute.vue');
// prettier-ignore
const CarroProcess_PagamentoDetails = () => import('@/entities/carro-process/pagamento/pagamento-details.vue');
// prettier-ignore
const CarroProcess_PagamentoExecute = () => import('@/entities/carro-process/pagamento/pagamento-execute.vue');
// prettier-ignore
const CarroProcess_FecharCompraDetails = () => import('@/entities/carro-process/fechar-compra/fechar-compra-details.vue');
// prettier-ignore
const CarroProcess_FecharCompraExecute = () => import('@/entities/carro-process/fechar-compra/fechar-compra-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/carro',
    name: 'Carro',
    component: Carro,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/carro/:carroId/view',
    name: 'CarroView',
    component: CarroDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/instance/:processInstanceId/view',
    name: 'CarroProcessView',
    component: CarroProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/instances',
    name: 'CarroProcessList',
    component: CarroProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/init',
    name: 'CarroStartFormInit',
    component: CarroStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/task/EscolherVeiculo/:taskInstanceId/view',
    name: 'CarroProcess_EscolherVeiculoDetails',
    component: CarroProcess_EscolherVeiculoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/task/EscolherVeiculo/:taskInstanceId/execute',
    name: 'CarroProcess_EscolherVeiculoExecute',
    component: CarroProcess_EscolherVeiculoExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/task/Pagamento/:taskInstanceId/view',
    name: 'CarroProcess_PagamentoDetails',
    component: CarroProcess_PagamentoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/task/Pagamento/:taskInstanceId/execute',
    name: 'CarroProcess_PagamentoExecute',
    component: CarroProcess_PagamentoExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/task/FecharCompra/:taskInstanceId/view',
    name: 'CarroProcess_FecharCompraDetails',
    component: CarroProcess_FecharCompraDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CarroProcess/task/FecharCompra/:taskInstanceId/execute',
    name: 'CarroProcess_FecharCompraExecute',
    component: CarroProcess_FecharCompraExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
