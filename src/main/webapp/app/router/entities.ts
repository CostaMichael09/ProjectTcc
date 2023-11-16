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
// prettier-ignore
const EmpresaVeiculo = () => import('@/entities/empresa-veiculo/empresa-veiculo.vue');
// prettier-ignore
const EmpresaVeiculoDetails = () => import('@/entities/empresa-veiculo/empresa-veiculo-details.vue');
// prettier-ignore
const EmpresaVeiculoProcessDetails = () => import('@/entities/empresa-veiculo-process/empresa-veiculo-process-details.vue');
// prettier-ignore
const EmpresaVeiculoProcessList = () => import('@/entities/empresa-veiculo-process/empresa-veiculo-process-list.vue');
// prettier-ignore
const EmpresaVeiculoStartFormInit = () => import('@/entities/empresa-veiculo-process/empresa-veiculo-start-form-init.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskRegularizarVeiculoDetails = () => import('@/entities/empresa-veiculo-process/task-regularizar-veiculo/task-regularizar-veiculo-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskRegularizarVeiculoExecute = () => import('@/entities/empresa-veiculo-process/task-regularizar-veiculo/task-regularizar-veiculo-execute.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskInclusaoDocDetails = () => import('@/entities/empresa-veiculo-process/task-inclusao-doc/task-inclusao-doc-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskInclusaoDocExecute = () => import('@/entities/empresa-veiculo-process/task-inclusao-doc/task-inclusao-doc-execute.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskVerificarEstadoDoVeiculoDetails = () => import('@/entities/empresa-veiculo-process/task-verificar-estado-do-veiculo/task-verificar-estado-do-veiculo-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskVerificarEstadoDoVeiculoExecute = () => import('@/entities/empresa-veiculo-process/task-verificar-estado-do-veiculo/task-verificar-estado-do-veiculo-execute.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskIncluirFotosDetails = () => import('@/entities/empresa-veiculo-process/task-incluir-fotos/task-incluir-fotos-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskIncluirFotosExecute = () => import('@/entities/empresa-veiculo-process/task-incluir-fotos/task-incluir-fotos-execute.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskAprovarFotosDetails = () => import('@/entities/empresa-veiculo-process/task-aprovar-fotos/task-aprovar-fotos-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskAprovarFotosExecute = () => import('@/entities/empresa-veiculo-process/task-aprovar-fotos/task-aprovar-fotos-execute.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskCadastrarAnuncioDetails = () => import('@/entities/empresa-veiculo-process/task-cadastrar-anuncio/task-cadastrar-anuncio-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskCadastrarAnuncioExecute = () => import('@/entities/empresa-veiculo-process/task-cadastrar-anuncio/task-cadastrar-anuncio-execute.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskRevisarAnuncioDetails = () => import('@/entities/empresa-veiculo-process/task-revisar-anuncio/task-revisar-anuncio-details.vue');
// prettier-ignore
const EmpresaVeiculoProcess_TaskRevisarAnuncioExecute = () => import('@/entities/empresa-veiculo-process/task-revisar-anuncio/task-revisar-anuncio-execute.vue');
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
  {
    path: '/empresa-veiculo',
    name: 'EmpresaVeiculo',
    component: EmpresaVeiculo,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/empresa-veiculo/:empresaVeiculoId/view',
    name: 'EmpresaVeiculoView',
    component: EmpresaVeiculoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/instance/:processInstanceId/view',
    name: 'EmpresaVeiculoProcessView',
    component: EmpresaVeiculoProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/instances',
    name: 'EmpresaVeiculoProcessList',
    component: EmpresaVeiculoProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/init',
    name: 'EmpresaVeiculoStartFormInit',
    component: EmpresaVeiculoStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskRegularizarVeiculo/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskRegularizarVeiculoDetails',
    component: EmpresaVeiculoProcess_TaskRegularizarVeiculoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskRegularizarVeiculo/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskRegularizarVeiculoExecute',
    component: EmpresaVeiculoProcess_TaskRegularizarVeiculoExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskInclusaoDoc/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskInclusaoDocDetails',
    component: EmpresaVeiculoProcess_TaskInclusaoDocDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskInclusaoDoc/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskInclusaoDocExecute',
    component: EmpresaVeiculoProcess_TaskInclusaoDocExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskVerificarEstadoDoVeiculo/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskVerificarEstadoDoVeiculoDetails',
    component: EmpresaVeiculoProcess_TaskVerificarEstadoDoVeiculoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskVerificarEstadoDoVeiculo/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskVerificarEstadoDoVeiculoExecute',
    component: EmpresaVeiculoProcess_TaskVerificarEstadoDoVeiculoExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskIncluirFotos/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskIncluirFotosDetails',
    component: EmpresaVeiculoProcess_TaskIncluirFotosDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskIncluirFotos/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskIncluirFotosExecute',
    component: EmpresaVeiculoProcess_TaskIncluirFotosExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskAprovarFotos/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskAprovarFotosDetails',
    component: EmpresaVeiculoProcess_TaskAprovarFotosDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskAprovarFotos/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskAprovarFotosExecute',
    component: EmpresaVeiculoProcess_TaskAprovarFotosExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskCadastrarAnuncio/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskCadastrarAnuncioDetails',
    component: EmpresaVeiculoProcess_TaskCadastrarAnuncioDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskCadastrarAnuncio/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskCadastrarAnuncioExecute',
    component: EmpresaVeiculoProcess_TaskCadastrarAnuncioExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskRevisarAnuncio/:taskInstanceId/view',
    name: 'EmpresaVeiculoProcess_TaskRevisarAnuncioDetails',
    component: EmpresaVeiculoProcess_TaskRevisarAnuncioDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/EmpresaVeiculoProcess/task/TaskRevisarAnuncio/:taskInstanceId/execute',
    name: 'EmpresaVeiculoProcess_TaskRevisarAnuncioExecute',
    component: EmpresaVeiculoProcess_TaskRevisarAnuncioExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
