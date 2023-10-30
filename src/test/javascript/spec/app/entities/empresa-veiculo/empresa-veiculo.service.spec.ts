/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';

import EmpresaVeiculoService from '@/entities/empresa-veiculo/empresa-veiculo.service';
import { EmpresaVeiculo } from '@/shared/model/empresa-veiculo.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('EmpresaVeiculo Service', () => {
    let service: EmpresaVeiculoService;
    let elemDefault;

    beforeEach(() => {
      service = new EmpresaVeiculoService();
      elemDefault = new EmpresaVeiculo(
        0,
        'AAAAAAA',
        'AAAAAAA',
        false,
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        'AAAAAAA',
        false,
        'AAAAAAA',
        'AAAAAAA',
        false,
        0,
        false
      );
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign({}, elemDefault);
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of EmpresaVeiculo', async () => {
        const returnedFromService = Object.assign(
          {
            renavam: 'BBBBBB',
            placa: 'BBBBBB',
            docRegular: true,
            multa: 1,
            marca: 'BBBBBB',
            modelo: 'BBBBBB',
            anoFabricacao: 1,
            anoModelo: 1,
            cor: 'BBBBBB',
            estadoVeiculo: true,
            obsEstadoVeiculo: 'BBBBBB',
            fotos: 'BBBBBB',
            aprovarFotos: true,
            preco: 1,
            anuncioAprovado: true,
          },
          elemDefault
        );
        const expected = Object.assign({}, returnedFromService);
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of EmpresaVeiculo', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
