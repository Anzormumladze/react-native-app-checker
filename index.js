import { NativeModules, Platform } from 'react-native';

const { AppChecker } = NativeModules;

export const isAppInstalled = (packageName) => {
  if (Platform.OS === 'android') {
    return AppChecker.isAppInstalled(packageName);
  } else {
    throw new Error('App checking not supported on iOS yet.');
  }
};
